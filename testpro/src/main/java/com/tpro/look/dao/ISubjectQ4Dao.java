package com.tpro.look.dao;

import com.tpro.look.model.SubjectQ4;

public interface ISubjectQ4Dao {
    int deleteByPrimaryKey(Integer iid);

    int insert(SubjectQ4 record);

    int insertSelective(SubjectQ4 record);

    SubjectQ4 selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(SubjectQ4 record);

    int updateByPrimaryKey(SubjectQ4 record);
}