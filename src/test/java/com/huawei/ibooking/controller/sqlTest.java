package com.huawei.ibooking.controller;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class sqlTest {

//    @Autowired(required = false)

    @Autowired
    DataSource dataSource;
    @Test
    public void  conTextLoads() throws SQLException{
        System.out.println(dataSource.getConnection());
    }
}
