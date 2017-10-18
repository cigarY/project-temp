package com.testsystem.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.testsystem.dao.IUserDao;
import com.testsystem.model.User;
import com.testsystem.utils.DBHelper;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean add(User user) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "insert into u_msg(username,password,sex,email)"
				+ "values(?,?,?,?)";
		int result = dbhelper.executeUpdate(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getEmail());
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
		String sql = "select * from u_msg where username=?";
		ResultSet rs = dbHelper.executeQuery(sql, name);
		if (rs.next()) {
			String password = rs.getString("password");
			User user = new User(name, password);
			return user;
		}
		rs.close();
		return null;
	}

}
