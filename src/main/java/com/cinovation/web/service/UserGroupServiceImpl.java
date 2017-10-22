package com.cinovation.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.UserGroupEntity;
import com.cinovation.web.repository.UserGroupRepository;

@Service
@RepositoryEventHandler
public class UserGroupServiceImpl implements UserGroupService{

	@Autowired
	UserGroupRepository userGroupRepository;
	
	@Override
	public UserGroupEntity findById(String id) {
		return userGroupRepository.findOne(id);
	}
	
	@Override
	public List<UserGroupEntity> findAll() {
		return userGroupRepository.findAll();
	}
	
}
