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

import com.cinovation.web.entity.StatusEntity;
import com.cinovation.web.entity.functionality.DeseaseEntity;
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.entity.room.RoomCategoryEntity;
import com.cinovation.web.entity.room.RoomDetailEntity;

@Entity(name = "PatientAdministrationEntity")
@Table(name = "t_patient_administration")
public class PatientAdministrationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8268685679857448548L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@Column(name = "ref_no_administration")
	private String refnoadministrations;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", referencedColumnName = "ID")
	private PatientEntity patientEntity;

	// Treatment for Inpatient(1) or Outpatient(2)
	@Column(name = "adminoption")
	private String adminoption;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "desease_id", referencedColumnName = "ID")
	private DeseaseEntity deseaseEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dokter_id", referencedColumnName = "ID")
	private FunctionalityEntity functionalityEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_bed_id", referencedColumnName = "ID")
	private RoomBedEntity roomBedEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "insurance_id", referencedColumnName = "ID")
	private InsuranceEntity insuranceEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_category_id", referencedColumnName = "ID")
	private RoomCategoryEntity roomCategoryEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_details_id", referencedColumnName = "ID")
	private RoomDetailEntity roomDetailEntity;

	@Column(name = "insurancenumber")
	private String insurancenumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "process_status_id", referencedColumnName = "ID")
	private StatusEntity processstatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "internal_status_id", referencedColumnName = "ID")
	private StatusEntity internalstatus;

	@Column(name = "inDate")
	private Date inDate;

	@Column(name = "outDate")
	private Date outDate;

	@Column(name = "cost")
	private String cost;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "isDel")
	private int isDel;

	@Column(name = "delRemark")
	private String delRemark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRefnoadministrations() {
		return refnoadministrations;
	}

	public void setRefnoadministrations(String refnoadministrations) {
		this.refnoadministrations = refnoadministrations;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public String getAdminoption() {
		return adminoption;
	}

	public void setAdminoption(String adminoption) {
		this.adminoption = adminoption;
	}

	public DeseaseEntity getDeseaseEntity() {
		return deseaseEntity;
	}

	public void setDeseaseEntity(DeseaseEntity deseaseEntity) {
		this.deseaseEntity = deseaseEntity;
	}

	public FunctionalityEntity getFunctionalityEntity() {
		return functionalityEntity;
	}

	public void setFunctionalityEntity(FunctionalityEntity functionalityEntity) {
		this.functionalityEntity = functionalityEntity;
	}

	public RoomBedEntity getRoomBedEntity() {
		return roomBedEntity;
	}

	public void setRoomBedEntity(RoomBedEntity roomBedEntity) {
		this.roomBedEntity = roomBedEntity;
	}

	public RoomDetailEntity getRoomDetailEntity() {
		return roomDetailEntity;
	}

	public void setRoomDetailEntity(RoomDetailEntity roomDetailEntity) {
		this.roomDetailEntity = roomDetailEntity;
	}

	public InsuranceEntity getInsuranceEntity() {
		return insuranceEntity;
	}

	public void setInsuranceEntity(InsuranceEntity insuranceEntity) {
		this.insuranceEntity = insuranceEntity;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
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

	public StatusEntity getProcessstatus() {
		return processstatus;
	}

	public void setProcessstatus(StatusEntity processstatus) {
		this.processstatus = processstatus;
	}

	public StatusEntity getInternalstatus() {
		return internalstatus;
	}

	public void setInternalstatus(StatusEntity internalstatus) {
		this.internalstatus = internalstatus;
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

	public String getDelRemark() {
		return delRemark;
	}

	public void setDelRemark(String delRemark) {
		this.delRemark = delRemark;
	}

}
