package com.tpro.look.model;

public class Record {

	private Integer id;
	
    private Integer uid;

    private Integer errornum;

    private Integer rightnum;
    
    private Integer subject;

    private String test_time;

    private String errorsubject; 

	public Record() {
		super();
	}

	public Record(Integer id, Integer uid, Integer errornum, Integer rightnum, Integer subject, String test_time,
			String errorproject) {
		super();
		this.id = id;
		this.uid = uid;
		this.errornum = errornum;
		this.rightnum = rightnum;
		this.subject = subject;
		this.test_time = test_time;
		this.errorsubject = errorproject;
	}
	
	public Record(Integer uid, Integer errornum, Integer rightnum, Integer subject, String test_time,
			String errorproject) {
		super();
		this.uid = uid;
		this.errornum = errornum;
		this.rightnum = rightnum;
		this.subject = subject;
		this.test_time = test_time;
		this.errorsubject = errorproject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public String getTest_time() {
		return test_time;
	}

	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}

	public String getErrorproject() {
		return errorsubject;
	}

	public void setErrorproject(String errorproject) {
		this.errorsubject = errorproject;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", uid=" + uid + ", errornum=" + errornum + ", rightnum=" + rightnum + ", subject="
				+ subject + ", test_time=" + test_time + ", errorproject=" + errorsubject + "]";
	}
    
}