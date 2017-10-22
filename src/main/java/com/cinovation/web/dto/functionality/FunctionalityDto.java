package com.cinovation.web.dto.functionality;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.UserGroupEntity;
import com.cinovation.web.entity.functionality.PositionEntity;
import com.cinovation.web.entity.functionality.SMFEntity;
import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.entity.maintenance.ReligionEntity;
import com.cinovation.web.validator.custom.NumberValue;

public class FunctionalityDto {

	private String id;

	@NotNull
	private PositionEntity positionEntity;

	@NotNull
	private SMFEntity sMFEntity;

	private UserGroupEntity userGroupEntity;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

	@NotNull
	private GenderEntity genderEntity;

	private String birthplace;

	private Date birthday;

	private ReligionEntity religionEntity;

	/*
	 * Contact Info
	 */

	private String addrline1;

	private String addrline2;

	private String addrline3;

	private String addrline4;

	private String addrline5;

	private String postcode;

	private String mobilenumber;

	@NotEmpty
	@NumberValue
	private String salary;

	private Date inDate;

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

}
