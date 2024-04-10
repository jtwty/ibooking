package com.huawei.ibooking.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
public class StudentDO {



    private String stu_num;


    private String password;


    private String stu_name; // 将name字段对应到stu_name列


    private String phone;


    private String email;

    private LocalDateTime dateJoined; // 将datetime类型转换为Java的LocalDateTime类型

    public StudentDO(String stu_num, String password, String stu_name, String phone, String email, LocalDateTime dateJoined) {
        this.stu_num = stu_num;
        this.password = password;
        this.stu_name = stu_name;
        this.phone = phone;
        this.email = email;
        this.dateJoined = dateJoined;
    }


    // 可能还缺少学号字段，若SQL中stu_num字段存在，请添加
    // @Column(name = "stu_num", nullable = false, length = ...)
    // private String stuNum;
}