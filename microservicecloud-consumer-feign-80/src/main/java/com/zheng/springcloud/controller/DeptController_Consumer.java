package com.zheng.springcloud.controller;

import com.zheng.springcloud.entity.Dept;
import com.zheng.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {
    
    @Resource
    private DeptClientService clientService;
    
    @RequestMapping(value = "/add")
    public boolean add(Dept dept) {
        return clientService.add(dept);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return clientService.get(id);
    }

    @RequestMapping(value = "/list")
    public List<Dept> list() {
        return clientService.list();
    }
}
