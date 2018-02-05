package com.tpro.look.dao;

import java.util.List;

import com.tpro.look.model.User;

public interface IUserDao {
	void insert(User user);    
    boolean update(User user);    
    boolean delete(int id);    
    User findById(int id);    
    List<User> findAll(); 
}