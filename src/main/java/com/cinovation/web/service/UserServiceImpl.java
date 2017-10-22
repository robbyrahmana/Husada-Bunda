package com.cinovation.web.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.repository.UserRepository;

@Service
@RepositoryEventHandler
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Inject
	UserGroupService userGroupService;
	
	@Autowired
	HelperService helperService;

	@Override
	public UserEntity getUserListByCd(String CD) {
		return userRepository.findByUsername(CD);
	}
	
	@Override
	public UserEntity saveUser(UserEntity dataContainer) throws Exception {
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return userRepository.saveAndFlush(dataContainer);
		
	}
	
	@Override
	public UserEntity updateUser(UserEntity dataContainer) throws Exception {
		UserEntity data = userRepository.findOne(dataContainer.getId());
		
		data.setPassword(dataContainer.getPassword());
		if (dataContainer.getUserGroupEntity() != null) data.setUserGroupEntity(userGroupService.findById(dataContainer.getUserGroupEntity().getId()));
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		return userRepository.saveAndFlush(data);	
	}
	
}
