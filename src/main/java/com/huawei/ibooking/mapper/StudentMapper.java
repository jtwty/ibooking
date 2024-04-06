package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 查询所有学生
    List<StudentDO> getStudents();

    // 根据学号查询学生（假设SQL中存在stu_num字段）
    List<StudentDO> getStudentByStuNum(@Param("stu_num") string stu_num;

    // 保存（新增或更新）学生信息
    int saveOrUpdateStudent(@Param("stu") StudentDO stu);

    // 根据学号删除学生（假设SQL中存在stu_num字段）
    int deleteStudentByStuNum(@Param("stu_num") String stu_num);
}