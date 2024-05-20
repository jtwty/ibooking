package com.example.jpademo.dao;

import com.example.jpademo.domain.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SeatDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Seat seat) {
        jdbcTemplate.update("insert into seat (id, zid, rid, socket, today_book, next_book) values(?, ?, ?, ?, ?, ?)", seat.getId(), seat.getZid(), seat.getRid(), seat.isSocket(), seat.getToday_book(), seat.getNext_book());
    }

    public List<Map<String, Object>> searchAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM seat");
        return list;
    }

    public List<Map<String, Object>> searchId(int id) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM seat WHERE id = ?", id);
        return list;
    }

    public List<Map<String, Object>> searchZid(int zid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM seat WHERE zid = ?", zid);
        return list;
    }

    public List<Map<String, Object>> searchRid(int rid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM seat WHERE rid = ?", rid);
        return list;
    }

    public void updateToday(Seat seat, int id, String today_book) {
        jdbcTemplate.update("update seat set id=?,zid=?,rid=?,socket=?,today_book=?,next_book=? where id=?", seat.getId(), seat.getZid(), seat.getRid(), seat.isSocket(), today_book, seat.getNext_book(), id);
    }

    public void updateNext(Seat seat, int id, String next_book) {
        jdbcTemplate.update("update seat set id=?,zid=?,rid=?,socket=?,today_book=?,next_book=? where id=?", seat.getId(), seat.getZid(), seat.getRid(), seat.isSocket(), seat.getToday_book(), next_book, id);
    }
}
