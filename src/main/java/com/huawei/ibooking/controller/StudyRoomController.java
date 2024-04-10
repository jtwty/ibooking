package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudyroomBusiness;
import com.huawei.ibooking.model.StudyRoomDO;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudyRoomController {
    @Resource
    private StudyroomBusiness studyroomBusiness;

    @GetMapping(value = "/studyroom")
    public ResponseEntity<List<StudyRoomDO>> Lists() {

        List<StudyRoomDO> studyrooms=studyroomBusiness.getStudyRooms();
        return new ResponseEntity<>(studyrooms, HttpStatus.OK);
    }
}
