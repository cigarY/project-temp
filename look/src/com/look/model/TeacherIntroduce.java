package com.look.model;

public class TeacherIntroduce {
	
  private int tid;
  private String tname;
  private String tphone;
  private String tsummary;
  private String tenver1;
  private String tenver2;
  private String tenver3;
  private String tenver4;
  private int tage;
  private String tschool;
  private int tprice;
  
public TeacherIntroduce() {
	super();
}

public TeacherIntroduce(int tid, String tname, String tphone, String tsummary, String tenver1, String tenver2,
		String tenver3, String tenver4, int tage, String tschool, int tprice) {
	super();
	this.tid = tid;
	this.tname = tname;
	this.tphone = tphone;
	this.tsummary = tsummary;
	this.tenver1 = tenver1;
	this.tenver2 = tenver2;
	this.tenver3 = tenver3;
	this.tenver4 = tenver4;
	this.tage = tage;
	this.tschool = tschool;
	this.tprice = tprice;
}

public int getTid() {
	return tid;
}

public void setTid(int tid) {
	this.tid = tid;
}

public String getTname() {
	return tname;
}

public void setTname(String tname) {
	this.tname = tname;
}

public String getTphone() {
	return tphone;
}

public void setTphone(String tphone) {
	this.tphone = tphone;
}

public String getTsummary() {
	return tsummary;
}

public void setTsummary(String tsummary) {
	this.tsummary = tsummary;
}

public String getTenver1() {
	return tenver1;
}

public void setTenver1(String tenver1) {
	this.tenver1 = tenver1;
}

public String getTenver2() {
	return tenver2;
}

public void setTenver2(String tenver2) {
	this.tenver2 = tenver2;
}

public String getTenver3() {
	return tenver3;
}

public void setTenver3(String tenver3) {
	this.tenver3 = tenver3;
}

public String getTenver4() {
	return tenver4;
}

public void setTenver4(String tenver4) {
	this.tenver4 = tenver4;
}

public int getTage() {
	return tage;
}

public void setTage(int tage) {
	this.tage = tage;
}

public String getTschool() {
	return tschool;
}

public void setTschool(String tschool) {
	this.tschool = tschool;
}

public int getTprice() {
	return tprice;
}

public void setTprice(int tprice) {
	this.tprice = tprice;
}

}
