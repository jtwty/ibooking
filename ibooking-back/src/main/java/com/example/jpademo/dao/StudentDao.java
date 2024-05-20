package com.example.jpademo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jpademo.domain.Student;

import java.util.List;
import java.util.Map;

//dao层，写对数据库的操作

//交给springboot管理的注解
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
        jdbcTemplate.update("insert into student (sid, sname, email, phone, password) values(?, ?, ?, ?, ?)", student.getSid(), student.getSname(), student.getEmail(), student.getPhone(), student.getPassword());
    }

    public List<Map<String, Object>> searchAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM student");
        return list;
    }

    public List<Map<String, Object>> searchSid(String sid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM student WHERE sid = ?", sid);
        return list;
    }

    public void deleteSid(String sid) {
        jdbcTemplate.update("DELETE FROM USER WHERE sid = ?", sid);
    }

    public void updateSid(Student student, String sid){
        jdbcTemplate.update("update student set sid=?,sname=?,email=?,phone=?,password=? where sid=?",student.getSid(), student.getSname(), student.getEmail(), student.getPhone(), student.getPassword(), sid);
    }
}
