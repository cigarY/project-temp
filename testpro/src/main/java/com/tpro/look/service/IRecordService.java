package com.tpro.look.service;

import java.util.List;

import com.tpro.look.model.Record;

public interface IRecordService {
	void insert(Record record);
	List<Record> findById(Integer uid);
	//����uid�Ϳ�Ŀ��ȡ
	List<Record> findByIdAndSubject(Integer uid,Integer subject);
	//��ȡ���⼯
	List<String> findes1ByUid(Integer uid);
	List<String> findes4ByUid(Integer uid);	
}
