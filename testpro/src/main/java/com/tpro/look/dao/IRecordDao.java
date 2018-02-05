package com.tpro.look.dao;

import com.tpro.look.model.Record;

public interface IRecordDao {
    int deleteByPrimaryKey(Integer uid);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}