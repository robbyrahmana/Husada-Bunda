package com.cinovation.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.UserGroupEntity;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity, String> {

}
