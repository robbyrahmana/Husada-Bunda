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

@Entity(name = "MenuHeaderEntity")
@Table(name = "c_menu_header")
public class MenuHeaderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4091044983114421816L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	/*
	 * RSSYSE-14
	 * Start Fix : MENU RUANGAN DI GABUNGKAN DENGAN PENGATURAN DENGAN BENTUK FOLDER DI DALAM PENGATURAN
	 * Description : add parent id of header for multilevel
	 * ADD:
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", referencedColumnName = "ID")
	private MenuHeaderEntity menuHeaderEntity;
	/*
	 * End Fix
	 */
	
	@Column(name = "name")
	private String name;

	@Column(name = "icon")
	private String icon;

	@Column(name = "seqNo")
	private int seqNo;

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

	public MenuHeaderEntity getMenuHeaderEntity() {
		return menuHeaderEntity;
	}

	public void setMenuHeaderEntity(MenuHeaderEntity menuHeaderEntity) {
		this.menuHeaderEntity = menuHeaderEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
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
