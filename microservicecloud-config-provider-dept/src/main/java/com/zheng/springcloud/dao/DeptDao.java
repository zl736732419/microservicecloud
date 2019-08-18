package com.zheng.springcloud.dao;

import com.zheng.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@Mapper
public interface DeptDao {
    
    boolean add(Dept dept);
    
    Dept findById(Long id);
    
    List<Dept> findAll();
}
