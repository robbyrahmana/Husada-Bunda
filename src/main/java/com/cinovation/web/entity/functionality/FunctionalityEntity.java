package com.cinovation.web.entity.functionality;

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

import com.cinovation.web.entity.UserGroupEntity;
import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.entity.maintenance.ReligionEntity;

@Entity(name = "DokterEntity")
@Table(name = "t_functionality")
public class FunctionalityEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5506089469630132119L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "position_id", referencedColumnName = "ID")
	private PositionEntity positionEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "smf_id", referencedColumnName = "ID")
	private SMFEntity sMFEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sec_user_group_id", referencedColumnName = "ID")
	private UserGroupEntity userGroupEntity;

	@Column(name = "cd")
	private String cd;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_gender_id", referencedColumnName = "ID")
	private GenderEntity genderEntity;

	@Column(name = "birthplace")
	private String birthplace;

	@Column(name = "birthday")
	private Date birthday;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_religion_id", referencedColumnName = "ID")
	private ReligionEntity religionEntity;

	/*
	 * Contact Info
	 */
	@Column(name = "addrline1")
	private String addrline1;

	@Column(name = "addrline2")
	private String addrline2;

	@Column(name = "addrlin3")
	private String addrline3;

	@Column(name = "addrlin4")
	private String addrline4;

	@Column(name = "addrlin5")
	private String addrline5;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "mobilenumber")
	private String mobilenumber;

	@Column(name = "salary")
	private String salary;

	@Column(name = "inDate")
	private Date inDate;

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

	public PositionEntity getPositionEntity() {
		return positionEntity;
	}

	public void setPositionEntity(PositionEntity positionEntity) {
		this.positionEntity = positionEntity;
	}

	public SMFEntity getsMFEntity() {
		return sMFEntity;
	}

	public void setsMFEntity(SMFEntity sMFEntity) {
		this.sMFEntity = sMFEntity;
	}

	public UserGroupEntity getUserGroupEntity() {
		return userGroupEntity;
	}

	public void setUserGroupEntity(UserGroupEntity userGroupEntity) {
		this.userGroupEntity = userGroupEntity;
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

	public GenderEntity getGenderEntity() {
		return genderEntity;
	}

	public void setGenderEntity(GenderEntity genderEntity) {
		this.genderEntity = genderEntity;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public ReligionEntity getReligionEntity() {
		return religionEntity;
	}

	public void setReligionEntity(ReligionEntity religionEntity) {
		this.religionEntity = religionEntity;
	}

	public String getAddrline1() {
		return addrline1;
	}

	public void setAddrline1(String addrline1) {
		this.addrline1 = addrline1;
	}

	public String getAddrline2() {
		return addrline2;
	}

	public void setAddrline2(String addrline2) {
		this.addrline2 = addrline2;
	}

	public String getAddrline3() {
		return addrline3;
	}

	public void setAddrline3(String addrline3) {
		this.addrline3 = addrline3;
	}

	public String getAddrline4() {
		return addrline4;
	}

	public void setAddrline4(String addrline4) {
		this.addrline4 = addrline4;
	}

	public String getAddrline5() {
		return addrline5;
	}

	public void setAddrline5(String addrline5) {
		this.addrline5 = addrline5;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
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
