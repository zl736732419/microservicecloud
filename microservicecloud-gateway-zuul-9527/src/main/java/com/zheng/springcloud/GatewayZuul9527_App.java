package com.zheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author zhenglian
 * @Date 2019/8/13
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayZuul9527_App {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuul9527_App.class, args);
    }
}
