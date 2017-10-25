package com.cinovation.web.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.repository.UserRepository;
import com.cinovation.web.service.functionality.FunctionalityService;

@Service
@RepositoryEventHandler
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Inject
	FunctionalityService functionalityService;
	
	@Inject
	UserUserRoleService userUserRoleService;
	
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
		
		/*
		 * RSSYSE-1
		 * Start Fix : TIDAK BISA LOGIN
		 * Description : panggil method update set user group untuk update , dan panggil method insert user role (ROLE_APP)
		 * OLD:
		 * if (dataContainer.getUserGroupEntity() != null) data.setUserGroupEntity(userGroupService.findById(dataContainer.getUserGroupEntity().getId()));
		 * NEW:
		 */
		if (dataContainer.getUserGroupEntity() != null) {
			data.setUserGroupEntity(userGroupService.findById(dataContainer.getUserGroupEntity().getId()));
			functionalityService.updateFunctionalityUserGroup(dataContainer.getUsername(), dataContainer.getUserGroupEntity());
			userUserRoleService.saveUserRole(userRepository.findOne(dataContainer.getId()));
		}
		/*
		 * End Fix
		 */
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		return userRepository.saveAndFlush(data);	
	}
	
}
