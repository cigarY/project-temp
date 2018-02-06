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
// �˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�  
public class UserServiceImpl implements IUserService {  
 
    @Resource  
    private IUserDao userDao;  
  
    /**  
     * ����  id  ɾ�� ����  
     */  
    public boolean delete(int id) {  
        return userDao.delete(id);  
    }  
    /**  
     * ���� id ��ѯ ��Ӧ����  
     */  
    public User findById(int id) {  
       return userDao.findById(id);  
    }  
    /**  
     * ��������  
     */  
    public void insert(User user) {  
    	userDao.insert(user);  
    }  
    /**  
     * ���� id �޸Ķ�Ӧ����  
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