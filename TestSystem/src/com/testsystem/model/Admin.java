package com.testsystem.model;

public class Admin {
	int aid;
	String adminname;
	String adminpwd;
	
	public Admin() {
		super();
	}

	public Admin(String adminname, String adminpwd) {
		super();
		this.adminname = adminname;
		this.adminpwd = adminpwd;
	}

	public Admin(int aid, String adminname, String adminpwd) {
		super();
		this.aid = aid;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	
}
