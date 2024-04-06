package com.huawei.ibooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SeatDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer classId;
    private String classCampus;
    private String classBuilding;

    // 构造函数、getter和setter方法
    public Seat() {}

    public Seat(Integer classId, String classCampus, String classBuilding) {
        this.classId = classId;
        this.classCampus = classCampus;
        this.classBuilding = classBuilding;
    }

    // Getter and Setter methods
    // ...
}