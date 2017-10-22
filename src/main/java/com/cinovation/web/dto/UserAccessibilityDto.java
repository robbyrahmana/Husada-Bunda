package com.cinovation.web.dto;

import com.cinovation.web.entity.MenuEntity;
import com.cinovation.web.entity.UserGroupEntity;

public class UserAccessibilityDto {

	private String id;

	private UserGroupEntity userGroupEntity;

	private MenuEntity menuEntity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserGroupEntity getUserGroupEntity() {
		return userGroupEntity;
	}

	public void setUserGroupEntity(UserGroupEntity userGroupEntity) {
		this.userGroupEntity = userGroupEntity;
	}

	public MenuEntity getMenuEntity() {
		return menuEntity;
	}

	public void setMenuEntity(MenuEntity menuEntity) {
		this.menuEntity = menuEntity;
	}

}
