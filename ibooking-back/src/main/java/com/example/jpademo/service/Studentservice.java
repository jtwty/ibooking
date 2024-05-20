package com.example.jpademo.service;

import com.example.jpademo.domain.Student;

import java.util.List;
import java.util.Map;

public interface Studentservice {
    void save(Student student);
    List<Map<String, Object>> searchAll();
    public List<Map<String, Object>> searchSid(String sid);
    public void deleteSid(String sid);
    boolean updateSid(Student student, String sid);
}
