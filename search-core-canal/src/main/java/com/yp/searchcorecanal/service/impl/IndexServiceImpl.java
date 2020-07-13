package com.yp.searchcorecanal.service.impl;

import com.yp.bean.Question;
import com.yp.searchcorecanal.config.EsProperties;
import com.yp.searchcorecanal.service.ElasticService;
import com.yp.searchcorecanal.service.IndexService;
import com.yp.searchcorecanal.service.QuestionService;
import com.yp.searchcorecanal.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Service
@Slf4j
public class IndexServiceImpl implements IndexService {
    private static String cache_key = "search_question:%s";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    final String update = String.format(cache_key, "update");
    final String current = String.format(cache_key, "current");

    @Autowired
    private RedisService redisService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ElasticService elasticService;

    @Autowired
    private EsProperties esProperties;

    @Override
    public boolean generateIndex() {
        Map<String, String> indexCore = getIndexCore();
        String currentCore = indexCore.get("currentCore");
        String updateCore = indexCore.get("updateCore");

        List<Question> questionList = questionService.getAll();
        if (CollectionUtils.isEmpty(questionList)) {
            log.info("数据为空，不需要建立索引");
            return true;
        }

        List<Map<String, Object>> datas = setMapData(questionList);

        // 插入数据到es
        elasticService.addBulkIn(datas, updateCore);

        // 更新当前索引
        generateIndexAfterHandler(updateCore, currentCore);

        return true;

    }



    @Override
    public boolean generateIndex(int size) {
        Map<String, String> indexCore = getIndexCore();
        String currentCore = indexCore.get("currentCore");
        String updateCore = indexCore.get("updateCore");

        int total = questionService.getCount();
        if (total == 0) {
            log.info("数据为空，不需要建立索引");
            return true;
        }

        int page = total / size;
        if (page >= 100) {
            page = 100;
        }
        // total<100时，page == 0
        if (total % size != 0) {
            page++;
        }
        log.info("question数据库中记录为{}，size={}，page={}", total, size, page);
        ThreadPoolExecutor executorService =
                new ThreadPoolExecutor(10, 100, 100l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        for (int i = 1; i <= page; i++) {
            final int p = i;
            executorService.execute(()->{
                List<Question> questionList = questionService.getAllByPage(p,size);

                List<Map<String, Object>> datas = setMapData(questionList);
                elasticService.addBulkIn(datas, updateCore);
            });
        }

        generateIndexAfterHandler(updateCore, currentCore);

        return true;
    }

    /**
     * 构建数据集
     * @param questionList
     * @return
     */
    private List<Map<String, Object>> setMapData(List<Question> questionList) {
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        for (Question question : questionList) {
            // 这里到字段需要和数据库中字段一致，因为canal监听表数据改变时读取到是数据库中的列名
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", question.getId());
            map.put("name", question.getName());
            map.put("english_name", question.getEnglishName());
            map.put("description", question.getDescription());
            map.put("content", question.getContent());
            map.put("create_by", question.getCreateBy());
            map.put("update_by", question.getUpdateBy());
            map.put("create_time", format.format(question.getCreateTime()));
            map.put("update_time", format.format(question.getUpdateTime()));
            datas.add(map);

        }
        return datas;
    }

    /**
     * 建立完索引后的处理逻辑
     * @param updateCore
     * @param currentCore
     */
    private void generateIndexAfterHandler(String updateCore, String currentCore) {
        log.info("对question索引全量重建完成,进行集合的切换");
        redisService.set(update, currentCore);
        redisService.set(current, updateCore);

        log.info("切换成功,当前备份的索引集合为{}，正在服务中的索引集合为{}", currentCore, updateCore);
    }

    /**
     * 得到索引
     * @return
     */
    private Map<String, String> getIndexCore(){
        log.info("开始全量构建索引");
        String updateCore = redisService.get(update, String.class);
        if (StringUtils.isEmpty(updateCore)) {
            updateCore = esProperties.getUpdatecore();
        }

        String currentCore = redisService.get(current, String.class);
        if (StringUtils.isEmpty(currentCore)) {
            currentCore = esProperties.getCurrentcore();
        }
        log.info("当前备份索引集合:{},正在服务中对索引集合:{}", updateCore, currentCore);

        Map<String, String> map = new HashMap<>();
        map.put("updateCore",updateCore);
        map.put("currentCore",currentCore);

        return map;
    }
}
