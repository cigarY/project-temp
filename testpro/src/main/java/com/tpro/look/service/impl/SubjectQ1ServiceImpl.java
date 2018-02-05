package com.tpro.look.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpro.look.dao.ISubjectQ1Dao;
import com.tpro.look.model.SubjectQ1;
import com.tpro.look.service.ISubjectQ1Service;

@Service  
@Transactional
public class SubjectQ1ServiceImpl implements ISubjectQ1Service {

	@Resource
	ISubjectQ1Dao subjectQ1dao;
	
	@Override
	public void insert(SubjectQ1 subjectQ1) {
		subjectQ1dao.insert(subjectQ1);
	}

	@Override
	public boolean update(SubjectQ1 subjectQ1) {
		return subjectQ1dao.update(subjectQ1);
	}

	@Override
	public boolean delete(int id) {
		return subjectQ1dao.delete(id);
	}

	@Override
	public SubjectQ1 findById(int id) {
		return subjectQ1dao.findById(id);
	}

	@Override
	public List<SubjectQ1> findAll(Map<String,Object> map) {
		return subjectQ1dao.findAll(map);
	}

	@Override
	public int getPageCount() {
		return subjectQ1dao.getPageCount();
	}

	@Override
	public List<SubjectQ1> findListByKeyWords(Map<String, Object> map, String keyWords) {
		return subjectQ1dao.findListByKeyWords(map, keyWords);
	}

}
