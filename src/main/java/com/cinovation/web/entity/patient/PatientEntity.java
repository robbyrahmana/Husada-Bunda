package com.cinovation.web.entity.patient;

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

import com.cinovation.web.entity.maintenance.EducationEntity;
import com.cinovation.web.entity.maintenance.GenderEntity;
import com.cinovation.web.entity.maintenance.BloodGroupEntity;
import com.cinovation.web.entity.maintenance.IdentityEntity;
import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.entity.maintenance.RelationshipEntity;
import com.cinovation.web.entity.maintenance.ReligionEntity;
import com.cinovation.web.entity.maintenance.RhesusEntity;
import com.cinovation.web.entity.maintenance.TitleEntity;
import com.cinovation.web.entity.maintenance.TribeEntity;
import com.cinovation.web.entity.maintenance.WorkEntity;
import com.cinovation.web.entity.room.RoomCategoryEntity;

@Entity(name = "PatientEntity")
@Table(name = "t_patient")
public class PatientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533063204933154883L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@Column(name = "ref_no_patient")
	private String refnopatient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_title_id", referencedColumnName = "ID")
	private TitleEntity titleEntity;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_gender_id", referencedColumnName = "ID")
	private GenderEntity genderEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_relationship_id", referencedColumnName = "ID")
	private RelationshipEntity relationshipEntity;

	@Column(name = "relationshipname")
	private String relationshipname;

	@Column(name = "parentname")
	private String parentname;

	@Column(name = "birthplace")
	private String birthplace;

	@Column(name = "birthday")
	private Date birthday;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_education_id", referencedColumnName = "ID")
	private EducationEntity educationEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_golongan_darah_id", referencedColumnName = "ID")
	private BloodGroupEntity bloodGroupEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_rhesus_id", referencedColumnName = "ID")
	private RhesusEntity rhesusEntity;

	@Column(name = "nationality")
	private String nationality;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_work_id", referencedColumnName = "ID")
	private WorkEntity workEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_identity_id", referencedColumnName = "ID")
	private IdentityEntity identityEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_religion_id", referencedColumnName = "ID")
	private ReligionEntity religionEntity;

	@Column(name = "identitynumber")
	private String identitynumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_tribe_id", referencedColumnName = "ID")
	private TribeEntity tribeEntity;

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

	/*
	 * Insurance
	 */

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_insurance_id", referencedColumnName = "ID")
	private InsuranceEntity insuranceEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_category_id", referencedColumnName = "ID")
	private RoomCategoryEntity roomCategoryEntity;

	@Column(name = "insurancenumber")
	private String insurancenumber;

	/*
	 * Emergency contact
	 */

	@Column(name = "emergency_name")
	private String emergencyname;

	@Column(name = "emergency_mobilenumber")
	private String emergencymobilenumber;

	@Column(name = "emergency_address")
	private String emergencyaddress;

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
