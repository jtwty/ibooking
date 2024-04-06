package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudentBusiness;
import com.huawei.ibooking.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentBusiness studentBusiness;

    @GetMapping(value = "/students")
    public ResponseEntity<List<StudentDO>> listStudents() {
        final List<StudentDO> students = studentBusiness.getStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{stu_num}")
    public ResponseEntity<StudentDO> queryStudentByStuNum(@PathVariable("stu_num") String stu_num) {
        Optional<StudentDO> studentOpt = studentBusiness.getStudentByStuNum(stu_num);

        return studentOpt.map(studentDO -> new ResponseEntity<>(studentDO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Void> addStudent(@RequestBody StudentDO student) {
        boolean result = studentBusiness.saveOrUpdateStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // PUT 方法用于更新整个实体，此处可保持原样，也可考虑提供单独的更新方法（例如：/students/{stuNum}/update）
    @PutMapping(value = "/students")
    public ResponseEntity<Void> saveStudent(@RequestBody StudentDO student) {
        boolean result = studentBusiness.saveOrUpdateStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/students/{stu_num}")
    public ResponseEntity<Void> deleteStudentByStuNum(@PathVariable("stu_num") String stu_num) {
        boolean result = studentBusiness.deleteStudentByStuNum(stu_num);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}