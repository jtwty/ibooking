package com.huawei.ibooking.mapper;


import com.huawei.ibooking.model.StudyRoomDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudyRoomMapper {
    @Select("select id,campus, building from classroom ")
    List<StudyRoomDO> getStudyRooms();

    @Insert("insert  into classroom (id, campus, building) values (#{id},#{campus},#{building})")
    int addStudyRoom(int id, String campus, String building);


    @Delete("delete from classroom where id = #{id}")
    int deleteStudyRoom(int id);


}
