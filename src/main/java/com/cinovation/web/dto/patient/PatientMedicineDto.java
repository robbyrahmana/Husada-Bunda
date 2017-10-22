package com.cinovation.web.dto.patient;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cinovation.web.entity.StatusEntity;
import com.cinovation.web.entity.patient.PatientAdministrationEntity;
import com.cinovation.web.entity.treatment.TreatmentBodyEntity;

public class PatientMedicineDto {

	private String id;

	private PatientAdministrationEntity patientAdministrationEntity;

	@NotNull
	private TreatmentBodyEntity treatmentBodyEntity;

	private String refnomedicine;

	private String totalCost;

	private StatusEntity status;

	private Date collectDate;

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

	public TreatmentBodyEntity getTreatmentBodyEntity() {
		return treatmentBodyEntity;
	}

	public void setTreatmentBodyEntity(TreatmentBodyEntity treatmentBodyEntity) {
		this.treatmentBodyEntity = treatmentBodyEntity;
	}

	public String getRefnomedicine() {
		return refnomedicine;
	}

	public void setRefnomedicine(String refnomedicine) {
		this.refnomedicine = refnomedicine;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
