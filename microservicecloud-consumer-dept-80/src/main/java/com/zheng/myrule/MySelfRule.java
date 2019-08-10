package com.zheng.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon负载均衡策略，覆盖spring cloud默认实现
 * @Author zhenglian
 * @Date 2019/8/10
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule loadBalanceRule() {
//        return new RandomRule();
        return new RoundRobinTimeLimitRule();
    }
}
