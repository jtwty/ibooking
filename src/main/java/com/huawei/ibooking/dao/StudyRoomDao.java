package com.huawei.ibooking.dao;


import com.huawei.ibooking.mapper.StudyRoomMapper;
import com.huawei.ibooking.model.StudyRoomDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudyRoomDao {

    @Resource
    private StudyRoomMapper mapper;

    public List<StudyRoomDO> getStudyRooms(){
        return mapper.getStudyRooms();
    }
    public int addStudyRoom(StudyRoomDO studyRoom){
        int id=studyRoom.getId();
        String campus=studyRoom.getCampus();
        String building=studyRoom.getBuilding();
        return mapper.addStudyRoom(id, campus, building);

    }
    public int deleteStudyRoom(int id){
        return mapper.deleteStudyRoom(id);
    }


}
