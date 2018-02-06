package com.tpro.look.service;

import java.util.List;
import java.util.Map;

import com.tpro.look.model.SubjectQ4;

public interface ISubjectQ4Service {
	void insert(SubjectQ4 subjectQ4);    
    boolean update(SubjectQ4 subjectQ4);    
    boolean delete(int id);    
    SubjectQ4 findById(int id);    
    List<SubjectQ4> findAll(Map<String,Object> map);
    int getPageCount();
    List<SubjectQ4> findListByKeyWords(Map<String,Object> map);
}
