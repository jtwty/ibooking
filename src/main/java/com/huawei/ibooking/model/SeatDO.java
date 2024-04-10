package com.huawei.ibooking.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SeatDO {


    private int id;

    private Integer classId;
    private String classCampus;
    private String classBuilding;

    public SeatDO(int id, Integer classId, String classCampus, String classBuilding) {
        this.id = id;
        this.classId = classId;
        this.classCampus = classCampus;
        this.classBuilding = classBuilding;
    }
}