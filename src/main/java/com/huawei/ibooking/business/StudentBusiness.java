package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.StudentDao;
import com.huawei.ibooking.model.StudentDO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentBusiness {
    @Resource
    private StudentDao studentDao;

    public List<StudentDO> getStudents() {
        return studentDao.getStudents();
    }

    public Optional<StudentDO> getStudent(String stu_num) {
        List<StudentDO> students = studentDao.getStudent(stu_num);
        if (students.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(students.get(0));
    }

    public boolean saveStudent(final StudentDO stu) {
        return studentDao.saveStudent(stu);
    }

    public boolean deleteStudent(final String stu_num) {
        return studentDao.deleteStudent(stu_num);
    }
}
