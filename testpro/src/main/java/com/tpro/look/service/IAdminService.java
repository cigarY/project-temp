package com.tpro.look.service;

import com.tpro.look.model.Admin;

public interface IAdminService {
	Admin findByName(String name);
}
