package com.yp.searchcorecanal.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.google.common.collect.Lists;
import com.yp.searchcorecanal.config.CanalProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Component
@Slf4j
public class CanalClient implements DisposableBean {

    private CanalConnector canalConnector;

    @Autowired
    private CanalProperties canalProperties;

    @Bean
    public CanalConnector getCanalConnector() {
        // CanalConnectors.newSingleConnector
        log.info("开始连接cannal");
        canalConnector = CanalConnectors.newClusterConnector(Lists.newArrayList(
                new InetSocketAddress(canalProperties.getHostname(), canalProperties.getPort())),
                canalProperties.getDestination(), canalProperties.getUsername(), canalProperties.getPassword()
        );

        canalConnector.connect();

        canalConnector.subscribe(canalProperties.getFilterTable());
//        canalConnector.subscribe("*.*");

        canalConnector.rollback();
        log.info("cannal连接初始化成功");
        return canalConnector;
    }

    @Override
    public void destroy() throws Exception {
        if (canalConnector != null) {
            canalConnector.disconnect();
        }
    }
}
