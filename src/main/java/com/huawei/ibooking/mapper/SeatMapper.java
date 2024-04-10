package com.huawei.ibooking.mapper;

import com.huawei.ibooking.model.SeatDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SeatMapper {

    @Select("select * from seat")
    List<SeatDO> getAllSeats();

    @Insert("insert into seat (id,class_id,class_campus,class_building) values( #{id},#{class_id},#{class_campus},#{class_building})")
    int addSeat(int id, int class_id, String class_campus, String class_building);
}
