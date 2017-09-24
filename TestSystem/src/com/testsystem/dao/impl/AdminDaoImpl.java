package com.testsystem.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.testsystem.dao.IAdminDao;
import com.testsystem.model.Admin;
import com.testsystem.utils.DBHelper;

public class AdminDaoImpl implements IAdminDao{
	
	/**
	 * 添加管理�?
	 */
	@Override
	public boolean add(Admin admin) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "insert into admin(adminname,adminpwd) values (?,?)";
		int result = dbhelper.executeUpdate(sql, admin.getAdminname(),admin.getAdminpwd());
		return (result == 1);
	}

	/**
	 * 删除管理�?
	 */
	@Override
	public boolean delete(Admin admin) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "delete from admin where adminname=?";
		int result = dbhelper.executeUpdate(sql,admin.getAdminname());
		return (result == 1);
	}

	/**
	 * 修改管理�?
	 */
	@Override
	public boolean update(Admin admin) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();
		String sql = "update admin set adminname=?,adminpwd=?";
		int result = dbhelper.executeUpdate(sql, admin.getAdminname(),admin.getAdminpwd());
		return (result == 1);
	}

	/**
	 * 通过名字获取管理员信息，进行信息的判�?
	 */
	@Override
	public Admin getAdminByName(String name) throws Exception {
		DBHelper dbHelper = DBHelper.getDbHelper();
		String sql = "select * from admin where adminname=?";
		ResultSet rs = dbHelper.executeQuery(sql, name);
		if (rs.next()) {
			String password = rs.getString("adminpwd");
			Admin admin = new Admin(name, password);
			return admin;
		}
		rs.close();
		return null;
	}

	/**
	 * 通过条件查找管理�?
	 */
	@Override
	public List<Admin> search(Admin condition) throws Exception {
		DBHelper dbhelper = DBHelper.getDbHelper();	
		List<Admin> adminlist = new ArrayList<>();
		String sql = "select * from admin";
		String where = "";
		if (condition != null) {
			String name = condition.getAdminname();
			if (name != null && !"".equals(name)) {
				where = " where adminname like '%" + name + "%'";
			}
		}
		sql += where;
		ResultSet rs = dbhelper.executeQuery(sql);
		while(rs.next()){
			String adminname = rs.getString("adminname");
			String adminpwd = rs.getString("adminpwd");
			Admin admin = new Admin(adminname, adminpwd);
			adminlist.add(admin);
		}
		return adminlist;
	}

	@Override
	public List<Admin> search(Admin condition, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount(Admin condition, int pageSize) throws Exception {
		String sql = "select count(*) from admin ";
		String where = "";
		if (condition != null) {
			String name = condition.getAdminname();
			if (name != null && !"".equals(name)) {
				where = " where name like '%" + name + "%'";
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
