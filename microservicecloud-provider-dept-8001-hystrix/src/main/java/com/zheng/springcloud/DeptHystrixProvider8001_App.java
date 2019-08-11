package com.zheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@SpringBootApplication
@EnableEurekaClient // 将本服务注册到Eureka Server中
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 服务降级熔断 hystrix
public class DeptHystrixProvider8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixProvider8001_App.class, args);
    }
}
