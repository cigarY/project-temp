package com.tpro.look.dao;

import java.util.List;
import java.util.Map;

import com.tpro.look.model.SubjectQ4;

public interface ISubjectQ4Dao {
	void insert(SubjectQ4 object);    
    boolean update(SubjectQ4 object);    
    boolean delete(int id);    
    SubjectQ4 findById(int id);    
    List<SubjectQ4> findAll(Map<String,Object> map);
    int getPageCount();
    List<SubjectQ4> findListByKeyWords(Map<String,Object> map);
    List<SubjectQ4> findListWithoutItem3();
    List<SubjectQ4> findListChoose();
    List<SubjectQ4> findListDChoose();
    void updateWrongNum(int wrongnumber,int id);
    List<SubjectQ4> getHardTop100();
}