package com.huawei.ibooking.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SeatDO {


    private Long id;

    private Integer classId;
    private String classCampus;
    private String classBuilding;

}