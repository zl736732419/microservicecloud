package com.zheng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zheng.springcloud.entity.Dept;
import com.zheng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "deptHystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("未知的dept id" + id); // 异常触发熔断
        }
        return dept;
    }

    /**
     * 通过@HystrixCommand实现服务熔断，需要对每个微服务方法都提供对应的熔断方法。
     * 微服务接口方法与熔断方法紧密耦合在一起，同时接口方法也会急剧膨胀。
     * @param id
     * @return
     */
    public Dept deptHystrix_get(Long id) {
        return new Dept(id, "数据库没有找到指定id的记录", "数据库不存在");
    }
}
