package com.cinovation.web.service;

import java.util.List;

import com.cinovation.web.entity.UserGroupEntity;

public interface UserGroupService {

	UserGroupEntity findById(String id);
	
	List<UserGroupEntity> findAll();
	
}
