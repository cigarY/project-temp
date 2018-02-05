package com.tpro.look.model;

import java.util.Date;

public class Record {
    private Integer uid;

    private Integer errornum;

    private Integer rightnum;

    private Date time;

    private String subject;

    private Integer id;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getErrornum() {
        return errornum;
    }

    public void setErrornum(Integer errornum) {
        this.errornum = errornum;
    }

    public Integer getRightnum() {
        return rightnum;
    }

    public void setRightnum(Integer rightnum) {
        this.rightnum = rightnum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}