package com.look.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.look.model.StudentJudge;
import com.look.model.TeacherIntroduce;
import com.look.model.TeacherPower;
import com.look.utils.MySqlHelper;

public class T_PowerDao extends MySqlHelper {
	public List<TeacherPower> getAll(){
		List<TeacherPower> list=new ArrayList<TeacherPower>();
		String sql="select * from t_power";
		ResultSet rs=this.executeQuery(sql);
		try {
			while(rs.next()){
				list.add(new TeacherPower(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getFloat(7),rs.getInt(8)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}
	public  TeacherIntroduce getOne(int tid){
		String sql="select * from t_introduce where tid ="+tid;
		TeacherIntroduce intro=null;
		ResultSet rs=this.executeQuery(sql);
		try {
			while(rs.next()){
				System.out.println("查到数据");
				 intro =new TeacherIntroduce(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getInt(11));
			return intro;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return intro;
	}
	

	public List<StudentJudge> getJudge(int tid) {
		String sql = "select * from t_judge where tid =" + tid;
		 List<StudentJudge> list =new ArrayList<StudentJudge>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while (rs.next()) {
				System.out.println("查到评论数据");
				list.add(new StudentJudge(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return list;
	}
}
