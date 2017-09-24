package com.testsystem.model;

public class SubjectInfo {
	int iid;
	int id;
	String question;
	String answer;
	String item1;
	String item2;
	String item3;
	String item4;
	String explains;
	String url;
	int wrongnumber;
	
	public SubjectInfo(int id, String question, String answer, String item1, String item2, String item3, String item4,
			String explains, String url, int wrongnumber) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.explains = explains;
		this.url = url;
		this.wrongnumber = wrongnumber;
	}

	public SubjectInfo() {
		super();
	}

	public SubjectInfo(int iid, int id, String question, String answer, String item1, String item2, String item3,
			String item4, String explains, String url, int wrongnumber) {
		super();
		this.iid = iid;
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.explains = explains;
		this.url = url;
		this.wrongnumber = wrongnumber;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWrongnumber() {
		return wrongnumber;
	}

	public void setWrongnumber(int wrongnumber) {
		this.wrongnumber = wrongnumber;
	}
}
