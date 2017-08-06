package com.look.service.impl;

import java.util.List;

import com.look.dao.IUserDao;
import com.look.dao.impl.UserDaoImpl;
import com.look.model.User;
import com.look.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public int login(User user) {
		IUserDao dao = new UserDaoImpl(); //new UserDaoImpl();  // 数据访问层
		User userindb;
		try {
			userindb = dao.getUserByName(user.getName());
			if (userindb == null) {
				return CODE_USER_NOT_EXISTS;
			}
			if (!user.getPassword().equals(userindb.getPassword())) {
				return CODE_PASSWORD_ERROR;
			}
			return CODE_OK;
		} catch (Exception e) {
			e.printStackTrace();
			return CODE_DB_ERROR;
		}
	}

	@Override
	public boolean add(User user) throws Exception {
		IUserDao dao = new UserDaoImpl();
		boolean result = dao.add(user);
		return result;
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

}
