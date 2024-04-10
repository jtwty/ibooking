package com.huawei.ibooking.dao;


import com.huawei.ibooking.mapper.SeatMapper;
import com.huawei.ibooking.model.SeatDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatDao {
    @Resource
    private SeatMapper seatMapper;

    List<SeatDO> getAllSeats() {
        return seatMapper.getAllSeats();
    }

    boolean addSeat(SeatDO seat) {
        return seatMapper.addSeat(seat.getId(),seat.getClassId(),seat.getClassCampus(),seat.getClassBuilding()) > 0;
    }
}
