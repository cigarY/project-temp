package com.tpro.look.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpro.look.dao.ISubjectQ4Dao;
import com.tpro.look.model.SubjectQ4;
import com.tpro.look.service.ISubjectQ4Service;

@Service  
@Transactional
public class SubjectQ4ServiceImpl implements ISubjectQ4Service {

	@Resource
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

	@Override
	public List<SubjectQ4> findListWithoutItem3() {
		return subjectDao.findListWithoutItem3();
	}

	@Override
	public List<SubjectQ4> findListChoose() {
		return subjectDao.findListChoose();
	}

	@Override
	public List<SubjectQ4> findListDChoose() {
		return subjectDao.findListDChoose();
	}

	@Override
	public void updateWrongNum(int wrongnumber, int id) {
		subjectDao.updateWrongNum(wrongnumber, id);
	}

	@Override
	public List<SubjectQ4> getHardTop100() {
		return subjectDao.getHardTop100();
	}

}
