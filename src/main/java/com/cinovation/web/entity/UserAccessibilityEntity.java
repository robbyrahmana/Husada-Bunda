package com.cinovation.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "UserAccessibility")
@Table(name = "tbl_sec_user_accessibility")
public class UserAccessibilityEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3719964622660019648L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sec_user_group_id", referencedColumnName = "ID")
	private UserGroupEntity userGroupEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id", referencedColumnName = "ID")
	private MenuEntity menuEntity;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "isDel")
	private int isDel;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

}
