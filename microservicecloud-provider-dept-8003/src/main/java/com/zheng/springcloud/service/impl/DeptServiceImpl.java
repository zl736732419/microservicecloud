package com.zheng.springcloud.service.impl;

import com.zheng.springcloud.dao.DeptDao;
import com.zheng.springcloud.entity.Dept;
import com.zheng.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zhenglian
 * @Date 2019/7/31
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;
    
    @Override
    public boolean add(Dept dept) {
        return deptDao.add(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
