package com.example.jpademo.service;

import com.example.jpademo.domain.Record;

import java.util.List;
import java.util.Map;

public interface Recordservice {
    void save(Record record);
    List<Map<String, Object>> searchAll();
    public List<Map<String, Object>> searchSid(String sid);
    public List<Map<String, Object>> searchId(int id);
    public List<Map<String, Object>> searcher(String sid, int zid, int rid);
    public void updateStatus(int id, int status);
}
