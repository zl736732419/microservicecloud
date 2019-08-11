package com.zheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptFeignConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptFeignConsumer80_App.class, args);
    }
}
