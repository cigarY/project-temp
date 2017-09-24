package com.testsystem.service.impl;

import java.util.List;

import com.testsystem.dao.BaseDao;
import com.testsystem.service.BaseService;

/**
 * 完成基本的增删改查操作的业务类对�?
 * @author Administrator
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	protected BaseDao<T> dao = null;
	
	public BaseServiceImpl() {
		// TODO
	}
	
	public BaseServiceImpl(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public boolean add(T object) throws Exception {
		return dao.add(object);
	}

	@Override
	public boolean delete(T object) throws Exception {
		return dao.delete(object);
	}

	@Override
	public boolean update(T object) throws Exception {
		return dao.update(object);
	}

	@Override
	public List<T> search(T condition, int pageSize, int pageNum) throws Exception {
		return dao.search(condition, pageSize, pageNum);
	}

	@Override
	public int getPageCount(T condition, int pageSize) throws Exception {
		return dao.getPageCount(condition, pageSize);
	}

}
