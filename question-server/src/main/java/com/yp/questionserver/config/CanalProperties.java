package com.yp.questionserver.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author by yuanpeng
 * @Date 2020/7/9
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = "search.canal")
public class CanalProperties {
    private String index;

    private String type;

    private String hostname;

    private int port;

    private String destination;

    private String username;

    private String password;

    // 监听的表
    private String filterTable;
}
