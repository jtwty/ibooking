package com.example.jpademo.service;

import com.example.jpademo.dao.RecordDao;
import com.example.jpademo.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RecordserviceImpl implements Recordservice {
    @Autowired
    private RecordDao dao;

    @Override
    public void save(Record record) {
        dao.save(record);
    }

    @Override
    public List<Map<String, Object>> searchAll() {
        return dao.searchAll();
    }

    @Override
    public List<Map<String, Object>> searchSid(String sid) {
        return dao.searchSid(sid);
    }

    @Override
    public List<Map<String, Object>> searchId(int id) {
        return dao.searchId(id);
    }

    @Override
    public List<Map<String, Object>> searcher(String sid, int zid, int rid) {
        return dao.searcher(sid, zid, rid);
    }

    public void updateStatus(int id, int status) {
        List<Map<String, Object>> list = dao.searchId(id);
        Map<String, Object> l = list.get(0);
        int zid = (int)l.get("zid");
        int rid = (int)l.get("rid");
        String sid = (String) l.get("sid");
        int start_time = (int)l.get("start_time");
        int end_time = (int)l.get("end_time");
        Date booking_date = (Date)l.get("booking_date");
        int s = (int)l.get("status");
        Record r = new Record(zid, rid, sid, start_time, end_time, booking_date, s);
        dao.updateStatus(r, status, id);
    }
}
