package com.testsystem.service;

import com.testsystem.model.SubjectInfo;

public interface ISubjectService extends BaseService<SubjectInfo>{
	/**
	 * 根据编号获取题目信息
	 * @param id 编号
	 * @return
	 */
	public SubjectInfo getSubjectById(int id) throws Exception;
	
	/**
	 * 统计科目�?题库中的总数
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;

}
