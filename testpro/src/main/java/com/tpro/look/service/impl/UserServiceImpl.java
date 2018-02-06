package com.tpro.look.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.tpro.look.dao.IUserDao;
import com.tpro.look.model.User;
import com.tpro.look.service.IUserService;  
  
 
@Service  
@Transactional  
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。  
public class UserServiceImpl implements IUserService {  
 
    @Resource  
    private IUserDao userDao;  
  
    /**  
     * 根据  id  删除 数据  
     */  
    public boolean delete(int id) {  
        return userDao.delete(id);  
    }  
    /**  
     * 根据 id 查询 对应数据  
     */  
    public User findById(int id) {  
       return userDao.findById(id);  
    }  
    /**  
     * 新增数据  
     */  
    public void insert(User user) {  
    	userDao.insert(user);  
    }  
    /**  
     * 根据 id 修改对应数据  
     */  
    public boolean update(User user) {  
        return userDao.update(user);  
    }
	@Override
	public List<User> findAll(Map<String, Object> map) {
		return userDao.findAll(map);
	}
	@Override
	public int getPageCount() {
		return userDao.getPageCount();
	}
	@Override
	public List<User> findListByKeyWords(Map<String, Object> map) {
		return userDao.findListByKeyWords(map);
	}
	  
}  