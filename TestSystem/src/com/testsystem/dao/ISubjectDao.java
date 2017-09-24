package com.testsystem.dao;

import com.testsystem.model.SubjectInfo;

public interface ISubjectDao extends BaseDao<SubjectInfo>{
	
	/**
	 * 根据学号获取题目信息
	 * @param id 题目编号
	 * @return
	 */
	public SubjectInfo getSubjectById(int id) throws Exception; 
	
	/**
	 * 统计科目�?题库中的总数
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;

	public int getPageCount(SubjectInfo condition, int pageSize) throws Exception;
	
}
