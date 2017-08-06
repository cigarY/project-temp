package com.look.service.impl;

import com.look.dao.BaseDao;
import com.look.dao.ISubjectDao;
import com.look.dao.impl.SubjectDaoImpl1;
import com.look.model.SubjectInfo;
import com.look.service.ISubjectService;

public class SubjectServiceImpl1 extends BaseServiceImpl<SubjectInfo> implements ISubjectService{
	
	public SubjectServiceImpl1() {
		dao = new SubjectDaoImpl1();
	}
	
	public SubjectServiceImpl1(BaseDao<SubjectInfo> dao) {		
		super(dao);
	}

	@Override
	public SubjectInfo getSubjectById(int id) throws Exception {
		return ((ISubjectDao)dao).getSubjectById(id);
	}

	@Override
	public int count() throws Exception {
		return ((ISubjectDao)dao).count();
	}
}
