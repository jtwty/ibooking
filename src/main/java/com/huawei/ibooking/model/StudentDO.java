package com.huawei.ibooking.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stu_num")
    private String stu_num;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "stu_name", nullable = false, length = 150)
    private String name; // 将name字段对应到stu_name列

    @Column(name = "phone", nullable = false, length = 254)
    private String phone;

    @Column(name = "email", nullable = false, length = 254)
    private String email;

    @Column(name = "date_joined", nullable = false)
    private LocalDateTime dateJoined; // 将datetime类型转换为Java的LocalDateTime类型

    public String  getStuNum() {
        return this.stu_num;
    }

    public void setStuNum(String stu_num) {
        this.stu_num = stu_num;
    }

    // 可能还缺少学号字段，若SQL中stu_num字段存在，请添加
    // @Column(name = "stu_num", nullable = false, length = ...)
    // private String stuNum;
}