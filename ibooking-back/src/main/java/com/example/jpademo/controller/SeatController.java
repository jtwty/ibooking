package com.example.jpademo.controller;

import com.example.jpademo.domain.Record;
import com.example.jpademo.domain.Seat;
import com.example.jpademo.service.Recordservice;
import com.example.jpademo.service.SeatserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.logging.Logger;

@RestController
public class SeatController {
    @Autowired
    private SeatserviceImpl seatservice;
    @Autowired
    private Recordservice recordservice;
    private static final Logger LOGGER = Logger.getLogger(SeatController.class.getName());

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

    @GetMapping("/api/student/seat/booking")
    public Object book(int id, int starttime, int endtime, String sid, boolean today) {
        LOGGER.info("/student/seat/booking");
        List<Map<String, Object>> list = seatservice.searchId(id);
        Map<String, Object> map = new HashMap<>();
        if (list.size() == 0) {
            return retFail(map);
        }
        String s;
        if (today) {
            s = (String) list.get(0).get("today_book");
        } else {
            s = (String) list.get(0).get("next_book");
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = starttime; i < endtime; i++) {
            if (stringBuilder.charAt(i) == '1') {
                return retFail(map);
            } else {
                stringBuilder.setCharAt(i, '1');
            }
        }
        List<Map<String, Object>> seats = seatservice.searchId(id);
        int rid = 0;
        if (seats != null) {
            rid = (int) seats.get(0).get("rid");
        }
        s = stringBuilder.toString();
        if (today) {
            seatservice.updateToday(id, s);
        } else {
            seatservice.updateNext(id, s);
        }
        recordservice.save(new Record(id, rid, sid, starttime, endtime, new Date(), 0));
        return retSuccess(map);
    }

    @GetMapping("/api/student/cancel/{bid}")
    public Object cancel(@PathVariable("bid") int bid) {
        LOGGER.info("cancel");
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = recordservice.searchId(bid);
        if (list.size() == 0) {
            return retFail(map);
        }
        int zid = (int) list.get(0).get("zid");
        int start_time = (int) list.get(0).get(("start_time"));
        int end_time = (int) list.get(0).get("end_time");
        Date date = (Date) list.get(0).get("booking_date");
        recordservice.updateStatus(bid, 2);
        boolean today = date.equals(new Date());
        List<Map<String, Object>> list2 = seatservice.searchZid(zid);
        String s;
        int id = (int) list2.get(0).get("id");
        if (today) {
            s = (String) list2.get(0).get("today_book");
        } else {
            s = (String) list2.get(0).get("next_book");
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = start_time; i < end_time; i++) {
            stringBuilder.setCharAt(i, '0');
        }
        s = stringBuilder.toString();
        if (today) {
            seatservice.updateToday(id, s);
        } else {
            seatservice.updateNext(id, s);
        }
        return retSuccess(map);
    }

    @GetMapping("/api/seat/list/{rid}")
    public Object seatList(@PathVariable("rid") int rid) {
        LOGGER.info("/api/seat/list/{rid}");
        List<Map<String, Object>> list = seatservice.searchRid(rid);
        List<Seat> s = new ArrayList<>();
        for (Map<String, Object> l : list) {
            int id = (int) l.get("id");
            int zid = (int) l.get("zid");
            boolean socket = (boolean) l.get("socket");
            String today_book = (String) l.get("today_book");
            String next_book = (String) l.get("next_book");
            Seat seat = new Seat(id, zid, rid, socket, today_book, next_book);
            s.add(seat);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("seats", s);
        return map;
    }

    @GetMapping("/api/seat/info/{id}")
    public Object seatInfo(@PathVariable("id") int id) {
        LOGGER.info("/api/seat/info/{id}");
        List<Map<String, Object>> list = seatservice.searchId(id);
        Map<String, Object> map = new HashMap<>();
        if (list.size() == 0) {
            return retFail(map);
        }
        Map<String, Object> l = list.get(0);
        int zid = (int) l.get("zid");
        int rid = (int) l.get("rid");
        boolean socket = (boolean) l.get("socket");
        String today_book = (String) l.get("today_book");
        String next_book = (String) l.get("next_book");
        Seat seat = new Seat(id, zid, rid, socket, today_book, next_book);
        map.put("code", 0);
        map.put("msg", "success");
        map.put("seat", seat);
        return map;
    }

    @GetMapping("/api/seat/free")
    public Object getFree(int rid, int starttime, int endtime, boolean today) {
        LOGGER.info("/api/seat/free");
        List<Map<String, Object>> list = seatservice.searchRid(rid);
        List<Seat> s = new ArrayList<>();
        String book;
        for (Map<String, Object> l : list) {
            int id = (int) l.get("id");
            int zid = (int) l.get("zid");
            boolean socket = (boolean) l.get("socket");
            String today_book = (String) l.get("today_book");
            String next_book = (String) l.get("next_book");
            if (today) {
                book = today_book;
            } else {
                book = next_book;
            }
            int j;
            for (j = starttime; j < endtime; j++) {
                if (book.charAt(j) == '1') {
                    break;
                }
            }
            if (j == endtime) {
                Seat seat = new Seat(id, zid, rid, socket, today_book, next_book);
                s.add(seat);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("seats", s);
        return map;
    }
}
