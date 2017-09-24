package com.testsystem.service.impl;

import java.util.List;

import com.testsystem.dao.IAdminDao;
import com.testsystem.dao.impl.AdminDaoImpl;
import com.testsystem.model.Admin;
import com.testsystem.service.IAdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin> implements IAdminService{

	@Override
	public List<Admin> search(Admin condition, int pageSize, int pageNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int login(Admin admin) {
		IAdminDao dao = new AdminDaoImpl(); //new UserDaoImpl();  // 数据访问�?
		Admin adminInDb;
		try {
			adminInDb = dao.getAdminByName(admin.getAdminname());
			if (adminInDb == null) {
				return CODE_USER_NOT_EXISTS;
			}
			if (!admin.getAdminpwd().equals(adminInDb.getAdminpwd())) {
				return CODE_PASSWORD_ERROR;
			}
			return CODE_OK;
		} catch (Exception e) {
			e.printStackTrace();
			return CODE_DB_ERROR;
		}
	}

}
