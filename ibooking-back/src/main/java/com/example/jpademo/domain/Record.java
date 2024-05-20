package com.example.jpademo.domain;

import java.util.Date;

public class Record {
    private int id;
    private int zid;
    private int rid;
    private String sid;
    private int start_time;
    private int end_time;
    private Date booking_date;
    private int status;

    public Record(int zid, int rid, String sid, int start_time, int end_time, Date booking_date, int status) {
        this.zid = zid;
        this.rid = rid;
        this.sid = sid;
        this.start_time = start_time;
        this.end_time = end_time;
        this.booking_date = booking_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
