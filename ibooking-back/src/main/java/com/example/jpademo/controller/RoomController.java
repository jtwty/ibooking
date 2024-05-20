package com.example.jpademo.controller;

import com.example.jpademo.domain.Room;
import com.example.jpademo.service.RoomserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class RoomController {
    @Autowired
    private RoomserviceImpl roomservice;
    private static final Logger LOGGER = Logger.getLogger(RoomController.class.getName());

    private Object retFail(Map<String, Object> map) {
        map.put("code", -1);
        map.put("msg", "failure");
        return map;
    }

    private Object retSuccess(Map<String, Object> map) {
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }

    @PostMapping("/api/admin/room/save")
    public Object setRoom(int rid, String rname, int seat_amount, int open_time, int close_time, boolean overnight, int max_booking_time) {
        LOGGER.info("/api/admin/room/save");
        Room r = new Room(rid, rname, seat_amount, open_time, close_time, overnight, max_booking_time, true);
        roomservice.save(r);
        Map<String, Object> map = new HashMap<>();
        return retSuccess(map);
    }

    @PostMapping("/api/admin/room/update")
    public Object changeRoom(int rid, String rname, int seat_amount, int open_time, int close_time, boolean overnight, int max_booking_time, boolean open) {
        LOGGER.info("/api/admin/room/update");
        Room r = new Room(rid, rname, seat_amount, open_time, close_time, overnight, max_booking_time, open);
        roomservice.updater(r);
        Map<String, Object> map = new HashMap<>();
        return retSuccess(map);
    }

    @GetMapping("/api/room/list")
    public Object roomList() {
        List<Map<String, Object>> list = roomservice.searchAll();
        List<Room> r = new ArrayList<>();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Map<String, Object> l = list.get(i);
            int rid = (int) l.get("rid");
            String rname = (String) l.get("rname");
            int seat_amount = (int) l.get("seat_amount");
            int open_time = (int) l.get("open_time");
            int close_time = (int) l.get("close_time");
            boolean overnight = (boolean) l.get("overnight");
            int max_booking_time = (int) l.get("max_booking_time");
            boolean open = (boolean) l.get("open");
            Room room = new Room(rid, rname, seat_amount, open_time, close_time, overnight, max_booking_time, open);
            r.add(room);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("records", r);
        return map;
    }

//
//    public Object seatVacancy(int id){
//        List<Map<String, Object>> list = roomservice.searchVacancy(id);
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", 0);
//        map.put("msg", "success");
//        map.put("records", list);
//        return map;
//    }
}
