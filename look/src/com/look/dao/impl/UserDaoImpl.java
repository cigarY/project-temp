package com.look.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.look.dao.IUserDao;
import com.look.model.User;
import com.look.utils.DBHelper;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean add(User user) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "insert into s_msg(sname,sage,ssex,simg,ssign,slocate,semail,sztime,tid,spwd)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		int result = dbhelper.executeUpdate(sql,user.getName(),user.getAge(),user.getSex(),user.getImg(),
				user.getSign(),user.getLocate(),user.getEmail(),user.getTime(),user.getTid(),user.getPassword());
		return (result == 1);
	}

	@Override
	public boolean delete(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> search(User condition, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount(User condition, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 通过名字获取用户信息，进行信息的判断
	 */
	@Override
	public User getUserByName(String name) throws Exception {
		DBHelper dbHelper = DBHelper.getDbHelper();
		String sql = "select * from s_msg where sname=?";
		ResultSet rs = dbHelper.executeQuery(sql, name);
		if (rs.next()) {
			String password = rs.getString("spwd");
			User user = new User(name, password);
			return user;
		}
		rs.close();
		return null;
	}

}
