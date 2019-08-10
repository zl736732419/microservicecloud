package com.zheng.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 指定某个微服务固定调用固定次数后负载到另一个微服务
 * @Author zhenglian
 * @Date 2019/8/10
 */
public class RoundRobinTimeLimitRule extends AbstractLoadBalancerRule {
    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

    /**
     * 默认同一个微服务调用5次后才进行切换
     */
    private static final Integer DEFAULT_TIMES = 5;

    /**
     * 同一个微服务调用次数限制，默认5次
     */
    private Integer times;
    
    private Integer nextServerCyclicCounter;
    /**
     * 当前微服务总调用次数
     */
    private Integer totalInvokeCounter;

    public RoundRobinTimeLimitRule() {
        times = DEFAULT_TIMES;
        nextServerCyclicCounter = 0;
        totalInvokeCounter = 0;
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }
            
            int nextServerIndex = getServerIndex(serverCount);
            server = allServers.get(nextServerIndex);

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: "
                    + lb);
        }
        return server;
    }

    private synchronized int getServerIndex(int serverCount) {
        totalInvokeCounter = (totalInvokeCounter+1) % times;
        if (totalInvokeCounter == 0) {
            nextServerCyclicCounter = (nextServerCyclicCounter+1) % serverCount;
        }
        return nextServerCyclicCounter;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
