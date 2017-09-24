package com.testsystem.model;

public class StudentJudge {
   private int tid;
   private int sid;
   private String sname;
   private String scon;
   private String stime;
public StudentJudge(int tid, int sid, String sname, String scon, String stime) {
	super();
	this.tid = tid;
	this.sid = sid;
	this.sname = sname;
	this.scon = scon;
	this.stime = stime;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getScon() {
	return scon;
}
public void setScon(String scon) {
	this.scon = scon;
}
public String getStime() {
	return stime;
}
public void setStime(String stime) {
	this.stime = stime;
}
   
}
