package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.AdminMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AdminDao {
    @Resource
    private AdminMapper adminMapper;


    public boolean addAdmin(int id,String password) {
        return adminMapper.addAdmin(id,password) > 0;
    }
}
