package com.cinovation.web.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cinovation.web.entity.StatusEntity;
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.entity.patient.PatientAdministrationEntity;
import com.cinovation.web.entity.treatment.TreatmentBodyEntity;
import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;

public class PatientTreatmentDto {

	private String id;

	private PatientAdministrationEntity patientAdministrationEntity;

	private TreatmentHeaderEntity treatmentHeaderEntity;

	@NotNull
	private TreatmentBodyEntity treatmentBodyEntity;

	private FunctionalityEntity functionalityEntity;

	private String cost;

	private String doktercost;

	private String remark;

	private StatusEntity status;

	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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

	public TreatmentHeaderEntity getTreatmentHeaderEntity() {
		return treatmentHeaderEntity;
	}

	public void setTreatmentHeaderEntity(
			TreatmentHeaderEntity treatmentHeaderEntity) {
		this.treatmentHeaderEntity = treatmentHeaderEntity;
	}

	public TreatmentBodyEntity getTreatmentBodyEntity() {
		return treatmentBodyEntity;
	}

	public void setTreatmentBodyEntity(TreatmentBodyEntity treatmentBodyEntity) {
		this.treatmentBodyEntity = treatmentBodyEntity;
	}

	public FunctionalityEntity getFunctionalityEntity() {
		return functionalityEntity;
	}

	public void setFunctionalityEntity(FunctionalityEntity functionalityEntity) {
		this.functionalityEntity = functionalityEntity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDoktercost() {
		return doktercost;
	}

	public void setDoktercost(String doktercost) {
		this.doktercost = doktercost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

}
