package com.cinovation.web.entity.treatment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TreatmentHeader")
@Table(name = "t_treatment_header")
public class TreatmentHeaderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7764526670614367733L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@Column(name = "cd")
	private String cd;

	@Column(name = "name")
	private String name;

	@Column(name = "showbody")
	private int showbody;

	@Column(name = "is_choose_by_user")
	private String isChooseByUser;

	@Column(name = "remark")
	private String remark;

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

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShowbody() {
		return showbody;
	}

	public void setShowbody(int showbody) {
		this.showbody = showbody;
	}

	public String getIsChooseByUser() {
		return isChooseByUser;
	}

	public void setIsChooseByUser(String isChooseByUser) {
		this.isChooseByUser = isChooseByUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
