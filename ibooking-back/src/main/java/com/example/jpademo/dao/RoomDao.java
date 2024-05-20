package com.example.jpademo.dao;

import com.example.jpademo.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RoomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> searchAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM room");
        return list;
    }


    public List<Map<String, Object>> searchSeat(int rid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM room WHERE rid = ?", rid);
        return list;

    }

    public List<Map<String, Object>> searchVacancy(int id) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM room WHERE id = ?", id);
        return list;

    }

    public void save(Room room) {
        jdbcTemplate.update("insert into room (rid, rname, seat_amount, open_time, close_time, overnight, max_booking_time, open) values(?, ?, ?, ?, ?, ?, ?, ?)", room.getRid(), room.getRname(), room.getSeat_amount(), room.getOpen_time(), room.getClose_time(), room.isOvernight(), room.getMax_booking_time(), room.isOpen());
    }

    public void updater(Room room, int rid) {
        jdbcTemplate.update("update room set rid=?, rname=?, seat_amount=?, open_time=?, close_time=?, overnight=?, max_booking_time=?, open=? where rid=?", room.getRid(), room.getRname(), room.getSeat_amount(), room.getOpen_time(), room.getClose_time(), room.isOvernight(), room.getMax_booking_time(), room.isOpen(), rid);
    }
}
