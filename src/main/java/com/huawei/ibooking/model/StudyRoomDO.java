package com.huawei.ibooking.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
public class StudyRoomDO {
    private int id;
    private String campus;
    private String building;

}
