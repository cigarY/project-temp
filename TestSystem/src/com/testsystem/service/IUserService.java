package com.testsystem.service;

import com.testsystem.model.User;

public interface IUserService extends BaseService<User>{
	/**
	 *  登录成功
	 */
	public static final int CODE_OK = 0;
	/**
	 * 用户名不存在
	 */
	public static final int CODE_USER_NOT_EXISTS = 1;
	/**
	 * 密码错误
	 */
	public static final int CODE_PASSWORD_ERROR = 2;
	/**
	 * 数据库访问出�?
	 */
	public static final int CODE_DB_ERROR = 3;
	
	/**
	 * 根据用户信息执行登录操作
	 * @param user 登录用户
	 * @return CODE_OK, CODE_USER_NOT_EXISTS ...
	 */
	public int login(User user);
	
}
