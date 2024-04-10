package com.huawei.ibooking.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    @Insert("insert  into admin (id,password) values (#{id},#{password})")
    int addAdmin(int id,String password);
}
