package com.example.jpademo.service;

import com.example.jpademo.dao.SeatDao;
import com.example.jpademo.domain.Seat;
import com.example.jpademo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatserviceImpl implements Seatservice {
    @Autowired
    private SeatDao dao;

    @Override
    public void save(Seat seat) {
        dao.save(seat);
    }

    @Override
    public List<Map<String, Object>> searchAll() {
        return dao.searchAll();
    }

    @Override
    public List<Map<String, Object>> searchId(int id) {
        return dao.searchId(id);
    }

    public List<Map<String, Object>> searchZid(int zid) {
        return dao.searchZid(zid);
    }

    public List<Map<String, Object>> searchRid(int rid) {
        return dao.searchRid(rid);
    }

    private Seat getNewById(int id) {
        List<Map<String, Object>> list = dao.searchId(id);
        Map<String, Object> l = list.get(0);
        int zid = (int) l.get("zid");
        int rid = (int) l.get("rid");
        boolean socket = (boolean) l.get("socket");
        String today_book = (String) l.get("today_book");
        String next_book = (String) l.get("next_book");
        return new Seat(id, zid, rid, socket, today_book, next_book);
    }

    @Override
    public void updateToday(int id, String today_book) {
        Seat s = getNewById(id);
        dao.updateToday(s, id, today_book);
    }

    @Override
    public void updateNext(int id, String next_book) {
        Seat s = getNewById(id);
        dao.updateNext(s, id, next_book);
    }
}
