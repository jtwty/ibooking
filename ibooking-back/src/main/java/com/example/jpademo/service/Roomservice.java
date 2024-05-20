package com.example.jpademo.service;

import com.example.jpademo.domain.Room;

import java.util.List;
import java.util.Map;

public interface Roomservice {
    public List<Map<String, Object>> searchAll();

    public List<Map<String, Object>> searchSeat(int rid);

    public List<Map<String, Object>> searchVacancy(int id);

    public void save(Room room);

    public void updater(Room room);
}
