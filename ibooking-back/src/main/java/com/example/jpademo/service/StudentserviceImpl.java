package com.example.jpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.domain.Student;
import com.example.jpademo.dao.StudentDao;

import java.util.List;
import java.util.Map;

@Service
public class StudentserviceImpl implements Studentservice {

    @Autowired
    private StudentDao dao;

    @Override
    public void save(Student student) {
        dao.save(student);
    }

    @Override
    public List<Map<String, Object>> searchAll() {
        return dao.searchAll();
    }

    @Override
    public List<Map<String, Object>> searchSid(String sid) {
        return dao.searchSid(sid);
    }
    @Override
    public void deleteSid(String sid) {
        dao.deleteSid(sid);
    }
    @Override
    public boolean updateSid(Student student, String sid) {
        dao.updateSid(student,sid);
        return false;
    }


}
