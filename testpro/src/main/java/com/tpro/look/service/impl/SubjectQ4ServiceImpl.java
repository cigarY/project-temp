package com.tpro.look.service.impl;

import java.util.List;
import java.util.Map;

import com.tpro.look.dao.ISubjectQ4Dao;
import com.tpro.look.model.SubjectQ4;
import com.tpro.look.service.ISubjectQ4Service;

public class SubjectQ4ServiceImpl implements ISubjectQ4Service {

	ISubjectQ4Dao subjectDao;
	
	@Override
	public void insert(SubjectQ4 subjectQ4) {
		subjectDao.insert(subjectQ4);
	}

	@Override
	public boolean update(SubjectQ4 subjectQ4) {
		return subjectDao.update(subjectQ4);
	}

	@Override
	public boolean delete(int id) {
		return subjectDao.delete(id);
	}

	@Override
	public SubjectQ4 findById(int id) {
		return subjectDao.findById(id);
	}

	@Override
	public List<SubjectQ4> findAll(Map<String, Object> map) {
		return subjectDao.findAll(map);
	}

	@Override
	public int getPageCount() {
		return subjectDao.getPageCount();
	}

	@Override
	public List<SubjectQ4> findListByKeyWords(Map<String, Object> map) {
		return subjectDao.findListByKeyWords(map);
	}

}
