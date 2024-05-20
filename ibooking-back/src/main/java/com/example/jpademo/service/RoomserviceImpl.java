package com.example.jpademo.service;

import com.example.jpademo.dao.RoomDao;
import com.example.jpademo.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomserviceImpl implements Roomservice {
    @Autowired
    private RoomDao dao;

    public List<Map<String, Object>> searchAll() {
        return dao.searchAll();
    }

    public List<Map<String, Object>> searchSeat(int rid) {
        return dao.searchSeat(rid);
    }

    public List<Map<String, Object>> searchVacancy(int id) {
        return dao.searchVacancy(id);
    }

    public void save(Room room) {
        dao.save(room);
    }

    public void updater(Room room) {
        int rid = room.getRid();
        dao.updater(room, rid);
    }
}
