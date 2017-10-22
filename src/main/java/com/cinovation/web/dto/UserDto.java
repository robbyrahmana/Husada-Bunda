package com.cinovation.web.dto;

import com.cinovation.web.entity.UserGroupEntity;

public class UserDto {

	private String id;

	private String username;

	private String password;

	private UserGroupEntity userGroupEntity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserGroupEntity getUserGroupEntity() {
		return userGroupEntity;
	}

	public void setUserGroupEntity(UserGroupEntity userGroupEntity) {
		this.userGroupEntity = userGroupEntity;
	}

}
