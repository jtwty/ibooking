package com.example.jpademo.controller;

import com.example.jpademo.domain.Record;
import com.example.jpademo.service.Recordservice;
import com.example.jpademo.service.RecordserviceImpl;
import com.example.jpademo.service.SeatserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class RecordController {
    @Autowired
    private RecordserviceImpl recordservice;
    @Autowired
    private SeatserviceImpl seatservice;
    private static final Logger LOGGER = Logger.getLogger(RecordController.class.getName());

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

    @GetMapping("/api/student/record/list/{sid}")
    public Object getRecord(@PathVariable("sid") String sid) {
        LOGGER.info("getRecord");
        List<Map<String, Object>> list = recordservice.searchSid(sid);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("records", list);
        return map;
    }

    @GetMapping("/api/student/signin")
    public Object signIn(String sid, int zid, int rid) {
        LOGGER.info("signIn");
        List<Map<String, Object>> list = recordservice.searcher(sid, zid, rid);
        Map<String, Object> map = new HashMap<>();
        if (list.size() == 0) {
            return retFail(map);
        }
        LocalTime currentTime = LocalTime.now();
        for (Map<String, Object> l : list) {
            int id = (int) l.get("id");
            int start_time = (int) l.get("start_time");
            int status = (int) l.get("status");
            if (status == 2) {
                return retFail(map);
            }
            LocalTime targetTime = LocalTime.of(start_time, 0);
            long minutes = currentTime.until(targetTime, ChronoUnit.MINUTES);
            if (minutes < 30) {
                recordservice.updateStatus(id, 1);
            } else {
                return retFail(map);
            }
        }
        return retSuccess(map);
    }

    @GetMapping("/api/student/onsite/book")
    public Object rush(int rid, int zid, int starttime, int endtime, String sid) {
        LOGGER.info("/api/student/onsite/book");
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = seatservice.searchZid(zid);
        if (list.size() == 0) {
            return retFail(map);
        }
        String today_book = (String) list.get(0).get("today_book");
        int id = (int) list.get(0).get("id");
        for (int i = starttime; i < endtime; i++) {
            if (today_book.charAt(i) == '1') {
                return retFail(map);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(today_book);
        for (int i = starttime; i < endtime; i++) {
            stringBuilder.setCharAt(i, '1');
        }
        today_book = stringBuilder.toString();
        seatservice.updateToday(id, today_book);
        Date d = new Date();
        Record r = new Record(zid, rid, sid, starttime, endtime, d, 0);
        recordservice.save(r);
        return retSuccess(map);
    }

    @GetMapping("/api/check")
    public Object needSignIn(int time, String sid) {
        LOGGER.info("needSignIn");
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = recordservice.searchSid(sid);
        if (list.size() == 0) {
            return retFail(map);
        }
        for (Map<String, Object> l : list) {
            int start_time = (int) l.get("start_time");
            int status = (int) l.get("status");
            if (status == 0 && start_time == time) {
                return retSuccess(map);
            }
        }
        return retFail(map);
    }
}
