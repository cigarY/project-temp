package com.look.service;

import com.look.model.SubjectInfo;

public interface ISubjectService extends BaseService<SubjectInfo>{
	/**
	 * 根据编号获取题目信息
	 * @param id 编号
	 * @return
	 */
	public SubjectInfo getSubjectById(int id) throws Exception;
	
	/**
	 * 统计科目一题库中的总数
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;

}
