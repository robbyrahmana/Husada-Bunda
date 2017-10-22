package com.cinovation.web.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.maintenance.BloodGroupEntity;
import com.cinovation.web.entity.maintenance.EducationEntity;
import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.entity.maintenance.IdentityEntity;
import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.entity.maintenance.RelationshipEntity;
import com.cinovation.web.entity.maintenance.ReligionEntity;
import com.cinovation.web.entity.maintenance.RhesusEntity;
import com.cinovation.web.entity.maintenance.TitleEntity;
import com.cinovation.web.entity.maintenance.TribeEntity;
import com.cinovation.web.entity.maintenance.WorkEntity;
import com.cinovation.web.entity.room.RoomCategoryEntity;

public class PatientDto {

	private String id;

	private String refnopatient;

	@NotNull
	private TitleEntity titleEntity;
	
	@NotEmpty
	private String name;

	@NotNull
	private GenderEntity genderEntity;

	private RelationshipEntity relationshipEntity;

	private String relationshipname;

	private String parentname;

	private String birthplace;

	private Date birthday;

	private EducationEntity educationEntity;

	private BloodGroupEntity bloodGroupEntity;

	private RhesusEntity rhesusEntity;

	private String nationality;

	private WorkEntity workEntity;

	private IdentityEntity identityEntity;

	private ReligionEntity religionEntity;

	private String identitynumber;

	private TribeEntity tribeEntity;

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

	/*
	 * Insurance
	 */

	private InsuranceEntity insuranceEntity;

	private RoomCategoryEntity roomCategoryEntity;

	private String insurancenumber;

	/*
	 * Emergency contact
	 */

	private String emergencyname;

	private String emergencymobilenumber;

	private String emergencyaddress;

	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRefnopatient() {
		return refnopatient;
	}

	public void setRefnopatient(String refnopatient) {
		this.refnopatient = refnopatient;
	}

	public TitleEntity getTitleEntity() {
		return titleEntity;
	}

	public void setTitleEntity(TitleEntity titleEntity) {
		this.titleEntity = titleEntity;
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

	public RelationshipEntity getRelationshipEntity() {
		return relationshipEntity;
	}

	public void setRelationshipEntity(RelationshipEntity relationshipEntity) {
		this.relationshipEntity = relationshipEntity;
	}

	public String getRelationshipname() {
		return relationshipname;
	}

	public void setRelationshipname(String relationshipname) {
		this.relationshipname = relationshipname;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
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

	public EducationEntity getEducationEntity() {
		return educationEntity;
	}

	public void setEducationEntity(EducationEntity educationEntity) {
		this.educationEntity = educationEntity;
	}

	public BloodGroupEntity getBloodGroupEntity() {
		return bloodGroupEntity;
	}

	public void setBloodGroupEntity(BloodGroupEntity bloodGroupEntity) {
		this.bloodGroupEntity = bloodGroupEntity;
	}

	public RhesusEntity getRhesusEntity() {
		return rhesusEntity;
	}

	public void setRhesusEntity(RhesusEntity rhesusEntity) {
		this.rhesusEntity = rhesusEntity;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public WorkEntity getWorkEntity() {
		return workEntity;
	}

	public void setWorkEntity(WorkEntity workEntity) {
		this.workEntity = workEntity;
	}

	public IdentityEntity getIdentityEntity() {
		return identityEntity;
	}

	public void setIdentityEntity(IdentityEntity identityEntity) {
		this.identityEntity = identityEntity;
	}

	public ReligionEntity getReligionEntity() {
		return religionEntity;
	}

	public void setReligionEntity(ReligionEntity religionEntity) {
		this.religionEntity = religionEntity;
	}

	public String getIdentitynumber() {
		return identitynumber;
	}

	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}

	public TribeEntity getTribeEntity() {
		return tribeEntity;
	}

	public void setTribeEntity(TribeEntity tribeEntity) {
		this.tribeEntity = tribeEntity;
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

	public InsuranceEntity getInsuranceEntity() {
		return insuranceEntity;
	}

	public void setInsuranceEntity(InsuranceEntity insuranceEntity) {
		this.insuranceEntity = insuranceEntity;
	}

	public RoomCategoryEntity getRoomCategoryEntity() {
		return roomCategoryEntity;
	}

	public void setRoomCategoryEntity(RoomCategoryEntity roomCategoryEntity) {
		this.roomCategoryEntity = roomCategoryEntity;
	}

	public String getInsurancenumber() {
		return insurancenumber;
	}

	public void setInsurancenumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}

	public String getEmergencyname() {
		return emergencyname;
	}

	public void setEmergencyname(String emergencyname) {
		this.emergencyname = emergencyname;
	}

	public String getEmergencymobilenumber() {
		return emergencymobilenumber;
	}

	public void setEmergencymobilenumber(String emergencymobilenumber) {
		this.emergencymobilenumber = emergencymobilenumber;
	}

	public String getEmergencyaddress() {
		return emergencyaddress;
	}

	public void setEmergencyaddress(String emergencyaddress) {
		this.emergencyaddress = emergencyaddress;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
