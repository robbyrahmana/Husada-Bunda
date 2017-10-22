package com.cinovation.web.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cinovation.web.entity.StatusEntity;
import com.cinovation.web.entity.functionality.DeseaseEntity;
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.entity.patient.PatientEntity;
import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.entity.room.RoomCategoryEntity;
import com.cinovation.web.entity.room.RoomDetailEntity;

public class PatientAdministrationDto {

	private String id;

	private String refnoadministrations;

	private PatientEntity patientEntity;

	// Treatment for Inpatient(1) or Outpatient(2)
	private String adminoption;

	@NotNull
	private DeseaseEntity deseaseEntity;

	@NotNull
	private FunctionalityEntity functionalityEntity;

	private RoomBedEntity roomBedEntity;

	private InsuranceEntity insuranceEntity;

	private RoomCategoryEntity roomCategoryEntity;

	private RoomDetailEntity roomDetailEntity;

	private String insurancenumber;

	private StatusEntity processstatus;

	private StatusEntity internalstatus;

	private Date inDate;

	private Date outDate;

	private String cost;

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

	public RoomDetailEntity getRoomDetailEntity() {
		return roomDetailEntity;
	}

	public void setRoomDetailEntity(RoomDetailEntity roomDetailEntity) {
		this.roomDetailEntity = roomDetailEntity;
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

}
