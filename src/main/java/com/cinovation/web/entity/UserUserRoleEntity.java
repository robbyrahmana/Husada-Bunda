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

@Entity(name = "UserUserRoleEntity")
@Table(name = "tbl_sec_user_user_roles")
public class UserUserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 26427417993621970L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sec_user_id", referencedColumnName = "ID")
	private UserEntity userEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sec_role_id", referencedColumnName = "ID")
	private UserRoleEntity userRoleEntity;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "isDel")
	private int isDel;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public UserRoleEntity getUserRoleEntity() {
		return userRoleEntity;
	}

	public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
		this.userRoleEntity = userRoleEntity;
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
