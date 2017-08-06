package com.look.dao;

import java.util.List;

import com.look.model.Admin;

public interface IAdminDao extends BaseDao<Admin>{
	
	/**
	 * 通过名字获取信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Admin getAdminByName(String name) throws Exception;
	
	/**
	 * 通过条件查找管理员信息
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public List<Admin> search(Admin condition) throws Exception;
}
