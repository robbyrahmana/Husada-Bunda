package com.cinovation.web.service;

import com.cinovation.web.entity.UserEntity;

public interface UserService {

	UserEntity getUserListByCd(String CD);
	
	UserEntity saveUser(UserEntity dataContainer) throws Exception;
	
	UserEntity updateUser(UserEntity dataContainer) throws Exception;
}
