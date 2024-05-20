package com.example.jpademo.domain;

import java.util.Date;

public class Room {
    private int rid;
    private String rname;
    private int seat_amount;
    private int open_time;
    private int close_time;
    private boolean overnight;
    private int max_booking_time;
    private boolean open;

    public Room(int rid, String rname, int seat_amount, int open_time, int close_time, boolean overnight, int max_booking_time, boolean open) {
        this.rid = rid;
        this.rname = rname;
        this.seat_amount = seat_amount;
        this.open_time = open_time;
        this.close_time = close_time;
        this.overnight = overnight;
        this.max_booking_time = max_booking_time;
        this.open = open;
    }

    public int getRid() {
        return rid;
    }

    public String getRname() {
        return rname;
    }

    public int getSeat_amount() {
        return seat_amount;
    }

    public int getOpen_time() {
        return open_time;
    }

    public int getClose_time() {
        return close_time;
    }

    public boolean isOvernight() {
        return overnight;
    }

    public int getMax_booking_time() {
        return max_booking_time;
    }

    public boolean isOpen() {
        return open;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setSeat_amount(int seat_amount) {
        this.seat_amount = seat_amount;
    }

    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }

    public void setClose_time(int close_time) {
        this.close_time = close_time;
    }

    public void setOvernight(boolean overnight) {
        this.overnight = overnight;
    }

    public void setMax_booking_time(int max_booking_time) {
        this.max_booking_time = max_booking_time;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
