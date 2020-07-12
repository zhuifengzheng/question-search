package com.yp.searchcorecanal.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author by yuanpeng
 * @Date 2020/7/9
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "search.es")
public class EsProperties {
    private String index;

    private String type;

    private String hostname;

    private int port;

    // es备份的库
    private String updatecore;

    // es当前工作的索引库
    private String currentcore;

}