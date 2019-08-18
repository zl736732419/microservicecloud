package com.zheng.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhenglian
 * @Date 2019/8/18
 */
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;
    
    @RequestMapping("/config")
    public String config() {
        return new StringBuilder("applicationName: ").append(applicationName)
                .append(", eurekaServer: ").append(eurekaServers)
                .append(", port: ").append(port).toString();
    }
}
