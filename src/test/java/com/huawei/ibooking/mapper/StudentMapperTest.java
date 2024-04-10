package com.huawei.ibooking.mapper;

import com.huawei.ibooking.BookingApplication;
import com.huawei.ibooking.mapper.StudentMapper;
import com.huawei.ibooking.model.StudentDO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals; // 添加这一行


import java.util.List;

@SpringBootTest(classes = BookingApplication.class)
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper; // 注入StudentMapper实例

    @BeforeEach
    public void setUp() {
        // 在每个测试方法执行前可以初始化一些数据，例如填充数据库
        // 此处省略，根据实际情况编写
    }

    @Test
    public void testGetStudent() {
        // 测试根据学号获取学生信息
        String stuNum = "23210240001";
        List<StudentDO> students = studentMapper.getStudent(stuNum);

        // 验证结果
//        assertNotNull(students, "查询结果不应该为null");
        // 根据实际业务逻辑添加更多断言验证
//        assertTrue(students.size() >= 1, "应至少返回一个结果");
        assertEquals(stuNum, students.get(0).getStu_num(), "学号应与查询条件一致");
    }

    // 其他方法测试...
}