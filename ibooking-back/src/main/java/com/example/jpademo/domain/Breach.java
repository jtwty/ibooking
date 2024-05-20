package com.example.jpademo.domain;

public class Breach {
    private int sid;
    private String bid;

    public Breach(int sid, String bid) {
        this.sid = sid;
        this.bid = bid;
    }

    public int getSid() {
        return sid;
    }

    public String getBid() {
        return bid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
