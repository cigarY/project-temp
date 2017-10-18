package com.testsystem.model;

import java.sql.Date;

public class User {
	private int uid;
	private String username;
	private String password;
	private String sex;
	private String email;
	private Date log_time;
	
	public User(String username, String password, String sex, String email) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}
	public User() {
		super();
	}
	public User(int uid, String username, String password, String sex, String email, Date log_time) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.log_time = log_time;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", sex="
				+ sex + ", email=" + email + ", log_time=" + log_time + "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLog_time() {
		return log_time;
	}
	public void setLog_time(Date log_time) {
		this.log_time = log_time;
	}
	
}
