package com.cinovation.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.UserAccessibilityEntity;

public interface UserAccessibilityRepository extends JpaRepository<UserAccessibilityEntity, String> {

	List<UserAccessibilityEntity> findByUserGroupEntityIdOrderByMenuEntitySeqNoAscMenuEntityMenuHeaderEntitySeqNoAsc(String ID);
	
}
