package com.tpro.look.dao;

import java.util.List;
import java.util.Map;

import com.tpro.look.model.SubjectQ1;

public interface ISubjectQ1Dao{
	void insert(SubjectQ1 object);    
    boolean update(SubjectQ1 object);    
    boolean delete(int id);    
    SubjectQ1 findById(int id);    
    List<SubjectQ1> findAll(Map<String,Object> map);
    int getPageCount();
    List<SubjectQ1> findListByKeyWords(Map<String,Object> map);
    List<SubjectQ1> findListWithoutItem3();
    List<SubjectQ1> findListOnlyItem3();
    void updateWrongNum(int wrongnumber,int id);
    List<SubjectQ1> getHardTop100();
}