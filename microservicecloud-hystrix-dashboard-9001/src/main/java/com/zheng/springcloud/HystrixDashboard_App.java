package com.zheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author zhenglian
 * @Date 2019/8/12
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard_App {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard_App.class, args);
    }
}
