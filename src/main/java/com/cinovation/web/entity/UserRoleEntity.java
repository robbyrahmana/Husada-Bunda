package com.cinovation.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "UserRoleEntity")
@Table(name = "tbl_sec_roles")
public class UserRoleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4033584144110588892L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String ID;

	@Column(name = "ROLE")
	private String ROLE;
	
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

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	
	@Override
	public String toString() {
		return "[Table : UserRoleEntity]";
	}
	
}
