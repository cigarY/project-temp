package com.tpro.look.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpro.look.dao.IAdminDao;
import com.tpro.look.model.Admin;
import com.tpro.look.service.IAdminService;

@Service  
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Resource  
    private IAdminDao adminDao; 
	
	@Override
	public Admin findByName(String name) {
		return adminDao.findByName(name);
	}

}
