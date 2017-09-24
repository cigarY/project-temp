package com.testsystem.service.impl;

import com.testsystem.dao.BaseDao;
import com.testsystem.dao.ISubjectDao;
import com.testsystem.dao.impl.SubjectDaoImpl4;
import com.testsystem.model.SubjectInfo;
import com.testsystem.service.ISubjectService;

public class SubjectServiceImpl4 extends BaseServiceImpl<SubjectInfo> implements ISubjectService {

	public SubjectServiceImpl4() {
		dao = new SubjectDaoImpl4();
	}
	
	public SubjectServiceImpl4(BaseDao<SubjectInfo> dao) {		
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
