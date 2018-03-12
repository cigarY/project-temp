package com.tpro.look.dao;

import java.util.List;
import java.util.Map;

import com.tpro.look.model.User;

public interface IUserDao {
	void insert(User user);    
    boolean update(User user);    
    boolean delete(int id);    
    User findById(int id); 
    User findByName(String name);
    List<User> findAll(Map<String,Object> map);
    int getPageCount();
    List<User> findListByKeyWords(Map<String,Object> map);
    boolean updateTime(User user);
}