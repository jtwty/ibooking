package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.StudentDO;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {
    @Resource
    private StudentMapper studentMapper;

    public List<StudentDO> getStudents() {
        return studentMapper.getStudents();
    }

    public List<StudentDO> getStudent(final String stu_num) {
        return studentMapper.getStudent(stu_num);
    }

    public boolean saveStudent(final StudentDO stu) {
        return studentMapper.saveStudent(stu) > 0;
    }

    public boolean deleteStudent(final String stu_num) {
        return studentMapper.deleteStudent(stu_num) > 0;
    }
}
