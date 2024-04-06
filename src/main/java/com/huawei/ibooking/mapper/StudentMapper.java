package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentDO> getStudents();

    List<StudentDO> getStudent(@Param("stu_num") String stu_num);

    int saveStudent(@Param("stu") StudentDO stu);

    int deleteStudent(@Param("stu_num") String stu_num);
}
