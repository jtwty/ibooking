package com.huawei.ibooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SeatDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer classId;
    private String classCampus;
    private String classBuilding;

    // 构造函数、getter和setter方法
    public void Seat() {}

    public void Seat(Integer classId, String classCampus, String classBuilding) {
        this.classId = classId;
        this.classCampus = classCampus;
        this.classBuilding = classBuilding;
    }

    // Getter and Setter methods
    // ...
}