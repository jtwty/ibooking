package com.huawei.ibooking.controller;

import com.huawei.ibooking.BookingApplication;
import com.huawei.ibooking.dao.StudentDao;
import com.huawei.ibooking.model.StudentDO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = BookingApplication.class)
public class StudentSqlTest {


    @Resource
    private StudentDao dao;
    @Test
    //对所有学生进行查询
    public void getStudentsTest() {
        List<StudentDO> students=dao.getStudents();
        System.out.println("测试开始");
        for(StudentDO student:students){
            System.out.println(student.getStu_num());
        }
    }

    @Test
    //对指定学号学生进行查询
    public void getStudentTest()
    {
        System.out.println("测试开始");
        String query_stu_num = "23210240001";

        List<StudentDO> students = dao.getStudent(query_stu_num);
        for(StudentDO student:students){
            System.out.println(student.getStu_num());
        }
    }

    @Test
    public void saveStudentTest() {

        System.out.println("测试开始");
        StudentDO newstudent=new StudentDO("23210240012","testpassword1","testusername2","11111111","22222222222", LocalDateTime.now());
        boolean flag=dao.saveStudent(newstudent);

        List<StudentDO> students=dao.getStudents();

        for(StudentDO student:students){
            System.out.println(student.getStu_num());

        }
    }
}
