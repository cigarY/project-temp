package com.tpro.look.service;

import java.util.List;
import java.util.Map;

import com.tpro.look.model.SubjectQ1;

public interface ISubjectQ1Service {
	void insert(SubjectQ1 subjectQ1);    
    boolean update(SubjectQ1 subjectQ1);    
    boolean delete(int id);    
    SubjectQ1 findById(int id);    
    List<SubjectQ1> findAll(Map<String,Object> map);
    int getPageCount();
    List<SubjectQ1> findListByKeyWords(Map<String,Object> map);
    List<SubjectQ1> findListWithoutItem3();
    List<SubjectQ1> findListOnlyItem3();
    void updateWrongNum(int wrongnumber,int id);
}
