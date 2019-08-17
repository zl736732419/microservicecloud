package com.zheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author zhenglian
 * @Date 2019/8/17
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer_App {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_App.class, args);
    }
}
