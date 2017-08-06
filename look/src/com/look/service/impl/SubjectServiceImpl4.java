package com.look.service.impl;

import com.look.dao.BaseDao;
import com.look.dao.ISubjectDao;
import com.look.dao.impl.SubjectDaoImpl4;
import com.look.model.SubjectInfo;
import com.look.service.ISubjectService;

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
