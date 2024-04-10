package com.huawei.ibooking.mapper;

import com.huawei.ibooking.BookingApplication;
import com.huawei.ibooking.model.SeatDO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BookingApplication.class)
public class SeatMapperTest {
    @Resource
    private SeatMapper seatMapper;

    @Test
    public void getAllseatsTest() {
        System.out.println(seatMapper.getAllSeats());
    }

    @Test
    public void addSeatTest(){

        seatMapper.addSeat(15,1,"邯郸校区","教学楼A");
        System.out.println(seatMapper.getAllSeats());
    }
}
