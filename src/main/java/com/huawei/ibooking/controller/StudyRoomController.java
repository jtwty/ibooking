package com.huawei.ibooking.controller;

import com.huawei.ibooking.business.StudyroomBusiness;
import com.huawei.ibooking.model.StudentDO;
import com.huawei.ibooking.model.StudyRoomDO;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudyRoomController {
    @Resource
    private StudyroomBusiness studyroomBusiness;

    @GetMapping(value = "/studyroom")
    public ResponseEntity<List<StudyRoomDO>> Lists() {

        List<StudyRoomDO> studyrooms=studyroomBusiness.getStudyRooms();
        return new ResponseEntity<>(studyrooms, HttpStatus.OK);
    }


    @GetMapping(value = "/studyroom/{id}")
    public ResponseEntity<StudyRoomDO> query(@PathVariable("id") int id) {
        Optional<StudyRoomDO> studyroom = studyroomBusiness.getStudyRoom(id);

        return studyroom.map(StudyRoomDO -> new ResponseEntity<>(StudyRoomDO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @PostMapping(value = "/")
    public ResponseEntity<Void> add(@RequestBody StudyRoomDO studyroom) {
        boolean result = studyroomBusiness.addStudyRoom(studyroom);

        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/studyroom/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        boolean result = studyroomBusiness.deleteStudyRoom(id);
        return new ResponseEntity<>(result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
