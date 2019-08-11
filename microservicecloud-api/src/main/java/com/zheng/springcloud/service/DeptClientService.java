package com.zheng.springcloud.service;

import com.zheng.springcloud.entity.Dept;
import com.zheng.springcloud.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * dept微服务 feign客户端实现
 * @Author zhenglian
 * @Date 2019/8/11
 */
@FeignClient(name = "MICROSERVICECLOUD-DEPT/dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
    Dept get(@PathVariable("id") Long id);
    
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    List<Dept> list();
    
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    boolean add(Dept dept);
}
