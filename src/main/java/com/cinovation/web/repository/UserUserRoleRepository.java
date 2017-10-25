package com.cinovation.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.UserUserRoleEntity;

/*
 * RSSYSE-1
 * Start Fix : TIDAK BISA LOGIN
 * Description : create repository untuk userrole supaya bisa insert dengan 1 method findByUserEntityId untuk verify
 * ADD:
 */
public interface UserUserRoleRepository extends JpaRepository<UserUserRoleEntity, String> {
	
	UserUserRoleEntity findByUserEntityId(String Id);
	
}
/*
 * End Fix
 */