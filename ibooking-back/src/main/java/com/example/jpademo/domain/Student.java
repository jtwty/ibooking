package com.example.jpademo.domain;

public class Student {
    private String sid;
    private String sname;
    private String email;
    private String phone;
    private String password;

    public Student(String sid, String sname, String email, String phone, String password) {
        this.sid = sid;
        this.sname = sname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}