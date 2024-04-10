package com.huawei.ibooking.dao;


import com.huawei.ibooking.mapper.SeatMapper;
import com.huawei.ibooking.model.SeatDO;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeeatDao {
    @Resource
    private SeatMapper seatMapper;

    List<SeatDO> getAllSeats() {
        return seatMapper.getAllSeats();
    }
}
