package com.look.model;

public class TeacherPower {
     private int tid;
     private String tname;
     private int tage;
     private String timg;
     private String tschool ;
     private String tdistance;
     private float  tgrade;
     private int tprice;
	public TeacherPower() {
		super();
	}
	public TeacherPower(int tid, String tname, int tage, String timg, String tschool, String tdistance, float tgrade,
			int tprice) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tage = tage;
		this.timg = timg;
		this.tschool = tschool;
		this.tdistance = tdistance;
		this.tgrade = tgrade;
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
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTimg() {
		return timg;
	}
	public void setTimg(String timg) {
		this.timg = timg;
	}
	public String getTschool() {
		return tschool;
	}
	public void setTschool(String tschool) {
		this.tschool = tschool;
	}
	public String getTdistance() {
	
		return tdistance;
	}
	public void setTdistance(String tdistance) {
		this.tdistance = tdistance;
	}
	public float getTgrade() {
		return tgrade;
	}
	public void setTgrade(float tgrade) {
		this.tgrade = tgrade;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	
}
