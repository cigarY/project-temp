package com.look.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.look.dao.ISubjectDao;
import com.look.model.SubjectInfo;
import com.look.utils.DBHelper;

public class SubjectDaoImpl4 implements ISubjectDao {

	@Override
	public List<SubjectInfo> search(SubjectInfo condition,int pageSize,int pageNum) throws Exception {
		DBHelper dbHelper = DBHelper.getDbHelper();
		String where = "";
		
		if (condition != null) {
			String question = condition.getQuestion();
			if (question != null && !"".equals(question)) {
				where = " where question like '%" + question + "%'";
			}
		}
		int begin = (pageNum-1) * pageSize;
		int end = 15;//这里是写死了15，后期优化
		String sql = "select * from examination_question4"+where+" order by iid limit "+begin+","+end;
		System.out.println(sql);
		List<SubjectInfo> subjectlist = new ArrayList<>();
		
		ResultSet rs = dbHelper.executeQuery(sql);
		while (rs.next()) {
			int iid = rs.getInt("iid");
			int id = rs.getInt("id");
			String question = rs.getString("question");
			String answer = rs.getString("answer");
			String item1 = rs.getString("item1");
			String item2 = rs.getString("item2");
			String item3 = rs.getString("item3");
			String item4 = rs.getString("item4");
			String explains = rs.getString("explains");
			String url = rs.getString("url");
			int wrongnumber = rs.getInt("wrongnumber");
			
			SubjectInfo subjectinfo = new SubjectInfo(iid, id, question, answer, item1, item2, item3, item4, explains, url, wrongnumber);
			subjectlist.add(subjectinfo);
		}
		rs.close();
		return subjectlist;
	}
	
	@Override
	public SubjectInfo getSubjectById(int id) throws Exception {
		SubjectInfo subjectInfo = null;
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "select * from examination_question4 where id=?";
		ResultSet rs = dbhelper.executeQuery(sql, id);
		if(rs.next()){
			int iid = rs.getInt("iid");
			String question = rs.getString("question");
			String answer = rs.getString("answer");
			String item1 = rs.getString("item1");
			String item2 = rs.getString("item2");
			String item3 = rs.getString("item3");
			String item4 = rs.getString("item4");
			String explains = rs.getString("explains");
			String url = rs.getString("url");
			int wrongnumber = rs.getInt("wrongnumber");
			
			subjectInfo = new SubjectInfo(iid, id, question, answer, item1, item2, item3, item4, explains, url, wrongnumber);
			
		}
		return subjectInfo;
	}

	@Override
	public boolean add(SubjectInfo subject) throws Exception {
		int result = 0;
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "insert into examination_question4"
				+ "(id, question, answer, item1, item2, item3, item4, explains, url, wrongnumber)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		result = dbhelper.executeUpdate(sql, subject.getId(),subject.getQuestion(),
				subject.getAnswer(),subject.getItem1(),subject.getItem2(),subject.getItem3(),
				subject.getItem4(),subject.getExplains(),subject.getUrl(),subject.getWrongnumber());
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(SubjectInfo subject) throws Exception {
		int result = 0;
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "delete from examination_question4 where id=?";
		result = dbhelper.executeUpdate(sql, subject.getId());
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(SubjectInfo subject) throws Exception {
		int result = 0;
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "update examination_question4 set question=?, answer=?, item1=?, "
				+ "item2=?, item3=?, item4=?, explains=?, url=?, wrongnumber=? where id=?";
		result = dbhelper.executeUpdate(sql, subject.getQuestion(),subject.getAnswer(),
				subject.getItem1(),subject.getItem2(),subject.getItem3(),subject.getItem4()
				,subject.getExplains(),subject.getUrl(),subject.getWrongnumber(),subject.getId());
		if(result == 1){
			return true;
		}
		return false;
	}

	@Override
	public int count() throws Exception {
		int countNum = 0;
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "select count(*) from examination_question4";
		ResultSet rs = dbhelper.executeQuery(sql);
		if(rs.next()){
			countNum = rs.getInt(1);
		}
		return countNum;
	}
	
	@Override
	public int getPageCount(SubjectInfo condition, int pageSize) throws Exception {
		String sql = "select count(*) from examination_question4 ";
		String where = "";
		if (condition != null) {
			String question = condition.getQuestion();
			if (question != null && !"".equals(question)) {
				where = " where question like '%" + question + "%'";
			}
		}
		sql += where;
		DBHelper dbHelper = DBHelper.getDbHelper();
		ResultSet rs = dbHelper.executeQuery(sql);
		int recordCount = 0;
		if (rs.next()) {
			recordCount = rs.getInt(1);			
		}
		rs.close();
		int pageCount = (recordCount+pageSize-1) / pageSize;
		return pageCount;
	}
}
