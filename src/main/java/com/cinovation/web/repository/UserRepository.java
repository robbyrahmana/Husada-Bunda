package com.cinovation.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByUsername(String cd);
	
}
