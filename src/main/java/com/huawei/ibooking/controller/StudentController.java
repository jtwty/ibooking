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
    private StudentBusiness stuBiz;

    @GetMapping(value = "/student")
    public ResponseEntity<List<StudentDO>> list() {
        final List<StudentDO> students = stuBiz.getStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/student/{stu_num}")
    public ResponseEntity<StudentDO> query(@PathVariable("stu_num") String stu_num) {
        Optional<StudentDO> stu = stuBiz.getStudent(stu_num);

        return stu.map(studentDO -> new ResponseEntity<>(studentDO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/student")
    public ResponseEntity<Void> add(@RequestBody StudentDO student) {
        boolean result = stuBiz.saveStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/student")
    public ResponseEntity<Void> save(@RequestBody StudentDO student) {
        boolean result = stuBiz.saveStudent(student);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/student/{stu_num}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("stu_num") String stu_num) {
        boolean result = stuBiz.deleteStudent(stu_num);
        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
