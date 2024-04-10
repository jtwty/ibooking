package com.huawei.ibooking.business;

import com.huawei.ibooking.dao.StudyRoomDao;
import com.huawei.ibooking.model.StudyRoomDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudyroomBusiness {
    @Resource
    private StudyRoomDao studyRoomDao;

    public List<StudyRoomDO> getStudyRooms() {
        return studyRoomDao.getStudyRooms();
    }
    public Optional<StudyRoomDO> getStudyRoom(final int id) {
        List<StudyRoomDO> studyrooms= studyRoomDao.getStudyRoom(id);

        if (studyrooms.isEmpty()) {
            return Optional.empty();
        }


        return Optional.ofNullable(studyrooms.get(0));
    }

    public boolean addStudyRoom(final StudyRoomDO studyRoom) {
        return studyRoomDao.addStudyRoom(studyRoom) ;
    }

    public boolean deleteStudyRoom(final int id) {
        return studyRoomDao.deleteStudyRoom(id);
    }


}
