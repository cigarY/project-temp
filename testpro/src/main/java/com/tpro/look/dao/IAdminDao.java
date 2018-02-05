package com.tpro.look.dao;

import com.tpro.look.model.Admin;

public interface IAdminDao {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}