package com.huawei.ibooking.dao;

import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {
    @Autowired
    private StudentMapper studentMapper;

    // 查询所有学生
    public List<StudentDO> getStudents() {
        return studentMapper.getStudents();
    }

    // 根据学号查询学生
    public StudentDO getStudentByStuNum(final String stu_num) {
        return studentMapper.getStudentByStuNum(stu_num);
    }

    // 保存（新增或更新）学生信息
    public boolean saveOrUpdateStudent(final StudentDO stu) {
        return studentMapper.saveOrUpdateStudent(stu) > 0;
    }

    // 根据学号删除学生
    public boolean deleteStudentByStuNum(final String stu_num) {
        return studentMapper.deleteStudentByStuNum(stu_num) > 0;
    }
}