package com.tpro.look.service;

import java.util.List;

import com.tpro.look.model.Record;

public interface IRecordService {
	void insert(Record record);
	List<Record> findById(Integer uid);
	//根据uid和科目获取
	List<Record> findByIdAndSubject(Integer uid,Integer subject);
		
}
