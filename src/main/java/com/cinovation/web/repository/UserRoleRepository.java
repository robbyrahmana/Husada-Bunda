package com.cinovation.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.UserRoleEntity;

/*
 * RSSYSE-1
 * Start Fix : TIDAK BISA LOGIN
 * Description : create repository untuk userrole supaya mengambil ID ROLE_APP
 * ADD:
 */
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String> {

}
/*
 * End Fix
 */