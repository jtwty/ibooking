package com.example.jpademo.dao;

import com.example.jpademo.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RecordDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Record record) {
        jdbcTemplate.update("insert into record (zid, rid, sid, start_time, end_time, booking_date, status) values(?, ?, ?, ?, ?, ?, ?)", record.getZid(), record.getRid(), record.getSid(), record.getStart_time(), record.getEnd_time(), record.getBooking_date(), record.getStatus());
    }

    public List<Map<String, Object>> searchAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM record");
        return list;
    }

    public List<Map<String, Object>> searchSid(String sid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM record WHERE sid = ?", sid);
        return list;
    }

    public List<Map<String, Object>> searchId(int id) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM record WHERE id = ?", id);
        return list;
    }

    public List<Map<String, Object>> searcher(String sid, int zid, int rid) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM record WHERE sid = ? and zid = ? and rid = ?", sid, zid, rid);
        return list;
    }

    public void updateStatus(Record record, int status, int id) {
        jdbcTemplate.update("update record set zid=?,rid=?,sid=?,start_time=?,end_time=?,booking_date=?,status=? where id=?", record.getZid(), record.getRid(), record.getSid(), record.getStart_time(), record.getEnd_time(), record.getBooking_date(), status, id);
    }
}
