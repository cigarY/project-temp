package com.look.dao;

import com.look.model.User;

public interface IUserDao extends BaseDao<User>{
	/**
	 * 通过名字获取信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public User getUserByName(String name) throws Exception;
}
