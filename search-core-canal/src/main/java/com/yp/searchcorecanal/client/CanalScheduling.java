package com.yp.searchcorecanal.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by yuanpeng
 * @Date 2020/7/8
 */
@Slf4j
@Component
public class CanalScheduling implements Runnable {


    @Autowired
    private CanalConnector canalConnector;

    @Autowired
    private RestHighLevelClient highLevelClient;

    /**
     * 这里是针对数据多的情况，一般来说可以写个定时任务，每天凌晨执行一次更新即可
     *
     * @Scheduled(cron = "0 0 0 * * ? *") -> 每天凌晨执行一次即可
     * @Scheduled(fixedDelay = 2000) -> 每两秒执行一次，数据更新频繁可以用
     */
    @Override
    @Scheduled(fixedDelay = 2000)
    public void run() {
        log.info("开始同步mysql中的数据");
        long batchId = -1;
        try {
            // 一次取1000条数据
            int batchSize = 1000;
            Message message = canalConnector.getWithoutAck(batchSize);
            batchId = message.getId();
            List<CanalEntry.Entry> entries = message.getEntries();
            if (batchId != -1 && entries.size() > 0) {
                entries.forEach(entry -> {
                    if (entry.getEntryType() == CanalEntry.EntryType.ROWDATA) {
                        // 解析处理
                        publishCanalEvent(entry);
                    }
                });
            }
            // 提交确认消费完毕
            canalConnector.ack(batchId);
        } catch (Exception e) {
            e.printStackTrace();
            // 失败的话进行回滚
            canalConnector.rollback(batchId);
        }

    }

    /**
     * 解析收到的日志事件
     *
     * @param entry
     */
    private void publishCanalEvent(CanalEntry.Entry entry) {
        log.info("收到canal消息{}", entry.toString());

        CanalEntry.RowChange change;
        try {
            change = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return;
        }
        CanalEntry.EventType eventType = change.getEventType();
        change.getRowDatasList().forEach(rowData -> {

            List<CanalEntry.Column> columns;
            // 对于es来说 只要关注 delete 和 update 还有insert
            if (eventType == CanalEntry.EventType.DELETE) {
                // 删除是拿到之前到数据，不然删除后就没有了
                columns = rowData.getBeforeColumnsList();
            } else {
                // 修改后到数据
                columns = rowData.getAfterColumnsList();
            }
            // 解析成map成格式
            Map<String, Object> dataMap = parseColumnsToMap(columns);
            // 存入es中
            indexES(dataMap, eventType);

        });
    }

    /**
     * 解析变化的列
     *
     * @param columns
     * @return
     */
    Map<String, Object> parseColumnsToMap(List<CanalEntry.Column> columns) {
        Map<String, Object> jsonMap = new HashMap<>();
        columns.forEach(column -> {
            if (column == null) {
                return;
            }
            jsonMap.put(column.getName(), column.getValue());
        });
        return jsonMap;
    }

    /**
     * 修改es数据
     *
     * @param dataMap
     * @param eventType
     */
    private void indexES(Map<String, Object> dataMap, CanalEntry.EventType eventType) {
        try {
            if (eventType == CanalEntry.EventType.DELETE) {
                log.info("删除索引Id={},type={},value={}", dataMap.get("id"), eventType.toString(), dataMap.toString());
                DeleteRequest deleteRequest = new DeleteRequest("book", "_doc", String.valueOf(dataMap.get("id")));
                highLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            } else {
                //如果是又业务关联的 这里就要写自己的业务代码
                log.info("更新索引Id={},type={},value={}", dataMap.get("id"), eventType.toString(), dataMap.toString());

                IndexRequest indexRequest = new IndexRequest("question", "index_question");
                indexRequest.id(String.valueOf(dataMap.get("id")));
                indexRequest.source(dataMap);
                highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

