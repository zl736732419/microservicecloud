package com.zheng.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@Configuration
public class ConfigBean {
    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public IRule loadBalanceRule() {
//        return new RandomRule();
        return new RetryRule();
    }
    
}
