package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.StudentDO;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StudentDao {
    @Resource
    private StudentMapper studentMapper;

    public List<StudentDO> getStudents() {
        return studentMapper.getStudents();
    }

    public List<StudentDO> getStudent(String stu_num) {
        return studentMapper.getStudent(stu_num);
    }

    public boolean saveStudent(final StudentDO stu) {
        String stu_num=stu.getStu_num();
        String password = stu.getPassword();
        String stu_name = stu.getStu_name();
        String phone = stu.getPhone();
        String email = stu.getEmail();
        LocalDateTime date_joined = stu.getDateJoined();
        return studentMapper.saveStudent(stu_num,password, stu_name, phone, email, date_joined) > 0;
    }

    public boolean deleteStudent(final String stu_num) {
        return studentMapper.deleteStudent(stu_num) > 0;
    }
}
