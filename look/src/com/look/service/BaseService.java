package com.look.service;

import java.util.List;

public interface BaseService<T> {
	/**
	 * 添加
	 * @param object 对象
	 * @return 成功-true, 失败-false
	 * @throws Exception
	 */
	public boolean add(T object) throws Exception;
	/**
	 * 删除
	 * @param object 对象
	 * @return 成功-true, 失败-false
	 * @throws Exception
	 */
	public boolean delete(T object) throws Exception;
	/**
	 * 修改
	 * @param object 对象
	 * @return 成功-true, 失败-false
	 * @throws Exception
	 */
	public boolean update(T object) throws Exception;
	/**
	 * 查询信息
	 * @param condition 查询条件
	 * @return 对象的List, 没有数据-null
	 * @throws Exception
	 */
	public List<T> search(T condition, int pageSize, int pageNum) throws Exception;

	/**
	 * 根据条件获取数据页数
	 * @param condition 条件
	 * @param pageSize 页大小
	 * @return
	 * @throws Exception
	 */
	public int getPageCount(T condition, int pageSize) throws Exception;
}
