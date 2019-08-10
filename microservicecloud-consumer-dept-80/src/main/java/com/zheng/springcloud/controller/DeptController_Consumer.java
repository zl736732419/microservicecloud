package com.zheng.springcloud.controller;

import com.zheng.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {
    
//    private static final String DEPT_REST_URL_PREFIX = "http://localhost:8001/dept";
    private static final String DEPT_REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT/dept";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value = "/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(DEPT_REST_URL_PREFIX +"/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept add(@PathVariable("id") Long id) {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX +"/get/" + id , Dept.class);
    }

    @RequestMapping(value = "/list")
    public List<Dept> list() {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX +"/list" , List.class);
    }

    @RequestMapping(value = "/discovery")
    public Object discovery() {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX +"/discovery", Object.class);
    }
}
