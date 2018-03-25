package com.tpro.look.dao;

import java.util.List;

import com.tpro.look.model.Record;

public interface IRecordDao {
	void insert(Record record);
	List<Record> findById(Integer uid);
	//根据uid和科目获取
	List<Record> findByIdAndSubject(Integer uid,Integer subject);
	
    int deleteByPrimaryKey(Integer uid);
    int insertSelective(Record record);
    int updateByPrimaryKeySelective(Record record);
    int updateByPrimaryKey(Record record);
}