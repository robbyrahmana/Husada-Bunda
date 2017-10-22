package com.cinovation.web.service;

import java.util.List;

import com.cinovation.web.entity.UserAccessibilityEntity;

public interface UserAccessibilityService {

	List<UserAccessibilityEntity> findByUserGroupId(String id);
	
}
