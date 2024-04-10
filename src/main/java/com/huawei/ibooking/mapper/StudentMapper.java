package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.StudentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select  *  from student")
    List<StudentDO> getStudents();

    List<StudentDO> getStudent(@Param("stu_num") String stu_num);
//    @Insert("insert into student (stu_num, password, stu_name) values (#{stu.stu_num}, #{stu.password}, #{stu.stu_name})")
    int saveStudent(@Param("stu") StudentDO stu);

    int deleteStudent(@Param("stu_num") String stu_num);
}
