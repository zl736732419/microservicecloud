package com.zheng.springcloud.service;

import com.zheng.springcloud.entity.Dept;

import java.util.List;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
