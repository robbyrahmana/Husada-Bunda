package com.cinovation.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.UserAccessibilityEntity;
import com.cinovation.web.repository.UserAccessibilityRepository;

@Service
@RepositoryEventHandler
public class UserAccessibilityServiceImpl implements UserAccessibilityService {
	
	private static final Logger logger = Logger.getLogger(UserAccessibilityServiceImpl.class);
	
	@Autowired
	UserAccessibilityRepository userAccessibilityRepository;
	
	public List<UserAccessibilityEntity> findByUserGroupId(String id) {
		return userAccessibilityRepository.findByUserGroupEntityIdOrderByMenuEntitySeqNoAscMenuEntityMenuHeaderEntitySeqNoAsc(id);
	}

}
