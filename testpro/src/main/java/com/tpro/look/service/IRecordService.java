package com.tpro.look.service;

import java.util.List;

import com.tpro.look.model.Record;

public interface IRecordService {
	void insert(Record record);
	List<Record> findById(Integer uid);
	//����uid�Ϳ�Ŀ��ȡ
	List<Record> findByIdAndSubject(Integer uid,Integer subject);
		
}
