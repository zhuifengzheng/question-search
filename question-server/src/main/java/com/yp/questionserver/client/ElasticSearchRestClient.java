package com.yp.questionserver.client;

import com.yp.questionserver.config.EsProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Component
public class ElasticSearchRestClient {

    @Autowired
    private EsProperties esProperties;

    @Bean
    public RestHighLevelClient highLevelClient(){
        HttpHost httpHost = new HttpHost(esProperties.getHostname(),esProperties.getPort());
        return new RestHighLevelClient(RestClient.builder(new HttpHost[]{httpHost}));
    }
}
