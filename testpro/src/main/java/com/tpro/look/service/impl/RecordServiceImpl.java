package com.tpro.look.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpro.look.dao.IRecordDao;
import com.tpro.look.model.Record;
import com.tpro.look.service.IRecordService;

@Service  
@Transactional
public class RecordServiceImpl implements IRecordService{

	@Resource
	private IRecordDao recordDao;
	
	@Override
	public void insert(Record record) {
		recordDao.insert(record);
	}

	@Override
	public List<Record> findById(Integer uid) {
		return recordDao.findById(uid);
	}

	@Override
	public List<Record> findByIdAndSubject(Integer uid, Integer subject) {
		return recordDao.findByIdAndSubject(uid, subject);
	}

	@Override
	public List<String> findes1ByUid(Integer uid) {
		return recordDao.findes1ByUid(uid);
	}

	@Override
	public List<String> findes4ByUid(Integer uid) {
		return recordDao.findes4ByUid(uid);
	}

	
}
