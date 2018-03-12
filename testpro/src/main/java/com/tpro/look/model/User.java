package com.tpro.look.model;

import java.util.Date;

public class User {
	public Integer uid;

    public String username;

    public String password;

    public String sex;

    public String email;

    public Date logTime;
    
    public User() {
		super();
	}

	public User(String username, String password, String sex, String email) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}