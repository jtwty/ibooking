package com.example.jpademo.service;

import com.example.jpademo.domain.Seat;
import com.example.jpademo.domain.Student;

import java.util.List;
import java.util.Map;

public interface Seatservice {
    void save(Seat seat);
    List<Map<String, Object>> searchAll();
    public List<Map<String, Object>> searchId(int id);
    public List<Map<String, Object>> searchZid(int zid);
    public List<Map<String, Object>> searchRid(int rid);
    void updateToday(int id, String today_book);
    void updateNext(int id, String next_book);
}
