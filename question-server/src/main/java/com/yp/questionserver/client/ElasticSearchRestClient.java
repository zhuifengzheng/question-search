package com.yp.questionserver.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Component
public class ElasticSearchRestClient {

    @Bean
    public RestHighLevelClient highLevelClient(){
        HttpHost httpHost = new HttpHost("127.0.0.1",9200);
        return new RestHighLevelClient(RestClient.builder(new HttpHost[]{httpHost}));
    }
}
