package com.example.jpademo.domain;

public class Seat {
    private int id;
    private int zid;
    private int rid;
    private boolean socket;
    private String today_book;
    private String next_book;

    public Seat(int zid, int rid, boolean socket, String today_book, String next_book) {
        this.zid = zid;
        this.rid = rid;
        this.socket = socket;
        this.today_book = today_book;
        this.next_book = next_book;
    }

    public Seat(int id, int zid, int rid, boolean socket, String today_book, String next_book) {
        this.id = id;
        this.zid = zid;
        this.rid = rid;
        this.socket = socket;
        this.today_book = today_book;
        this.next_book = next_book;
    }

    public int getId() {
        return id;
    }

    public int getZid() {
        return zid;
    }

    public int getRid() {
        return rid;
    }

    public boolean isSocket() {
        return socket;
    }

    public String getToday_book() {
        return today_book;
    }

    public String getNext_book() {
        return next_book;
    }

    public void setBid(int id) {
        this.id = id;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setSocket(boolean socket) {
        this.socket = socket;
    }

    public void setToday_book(String today_book) {
        this.today_book = today_book;
    }

    public void setNext_book(String next_book) {
        this.next_book = next_book;
    }
}
