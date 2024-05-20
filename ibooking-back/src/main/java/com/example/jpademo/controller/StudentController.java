package com.example.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jpademo.domain.Student;
import com.example.jpademo.service.StudentserviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class StudentController {
    @Autowired
    private StudentserviceImpl studentservice;
    private static final Logger LOGGER = Logger.getLogger(StudentController.class.getName());

    @PostMapping("/api/user/register")
    public Object register(String sid, String sname, String password, String email, String phone) {
        LOGGER.info("register");
        List<Map<String, Object>> list = studentservice.searchSid(sid);
        Map<String, Object> map = new HashMap<>();
        if (list.isEmpty()) {
            studentservice.save(new Student(sid, sname, email, phone, password));
            map.put("code", 0);
            map.put("msg", "注册成功");
        } else {
            map.put("code", -1);
            map.put("msg", "用户已存在");
        }
        return map;
    }

    @PostMapping("/api/student/login")
    public int login(String sid, String password) {
        LOGGER.info("login");
        List<Map<String, Object>> list = studentservice.searchSid(sid);
        if (list.isEmpty()) {
            return -1;
        } else {
            for (Map<String, Object> l : list) {
                String s = (String) l.get("password");
                if (s.equals(password)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    @PostMapping("/api/admin/login")
    public int adminLogin(String username, String password) {
        LOGGER.info("admin login");
        List<Map<String, Object>> list = studentservice.searchSid(username);
        if (list.isEmpty()) {
            return -1;
        } else {
            for (Map<String, Object> l : list) {
                String s = (String) l.get("password");
                if (s.equals(password)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
}
