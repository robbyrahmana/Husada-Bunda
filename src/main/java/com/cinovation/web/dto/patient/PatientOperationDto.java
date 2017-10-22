package com.cinovation.web.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.entity.patient.PatientAdministrationEntity;

public class PatientOperationDto {

	private String id;

	@NotNull
	private PatientAdministrationEntity patientAdministrationEntity;

	private FunctionalityEntity functionalityEntity;

	private String remark;

	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PatientAdministrationEntity getPatientAdministrationEntity() {
		return patientAdministrationEntity;
	}

	public void setPatientAdministrationEntity(
			PatientAdministrationEntity patientAdministrationEntity) {
		this.patientAdministrationEntity = patientAdministrationEntity;
	}

	public FunctionalityEntity getFunctionalityEntity() {
		return functionalityEntity;
	}

	public void setFunctionalityEntity(FunctionalityEntity functionalityEntity) {
		this.functionalityEntity = functionalityEntity;
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

}
