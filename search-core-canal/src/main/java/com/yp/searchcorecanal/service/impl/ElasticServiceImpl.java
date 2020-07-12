package com.yp.searchcorecanal.service.impl;

import com.google.common.base.Throwables;
import com.yp.bean.exception.ServiceException;
import com.yp.searchcorecanal.config.EsProperties;
import com.yp.searchcorecanal.service.ElasticService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Slf4j
@Service
public class ElasticServiceImpl implements ElasticService {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Autowired
    private EsProperties esProperties;

    @Override
    public boolean addBulkIn(List<Map<String, Object>> datas, String index) {
        try {

            BulkRequest bulkRequest = new BulkRequest();
            IndexRequest request;

            for (Map<String, Object> data : datas) {
                request = new IndexRequest("post");
                request.index(index).type(esProperties.getType()).id(String.valueOf(data.get("id"))).source(data);
                bulkRequest.add(request);
            }
            BulkResponse response = highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

            if (response.hasFailures()) {
                log.error("search.index.upsert.failed, cause:{}", response.buildFailureMessage());
                throw new ServiceException("search.index.upsert.failed");
            }

            return true;
        } catch (Exception e) {
            log.error("数据插入es失败,index={}", index, Throwables.getStackTraceAsString(e), e.getStackTrace());
        }
        return false;
    }


}
