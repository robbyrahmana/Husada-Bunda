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
import com.cinovation.web.entity.treatment.TreatmentBodyEntity;

@Entity(name = "PatientMedicineEntity")
@Table(name = "t_patient_medicine")
public class PatientMedicineEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158984644889051089L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_administration_id", referencedColumnName = "ID")
	private PatientAdministrationEntity patientAdministrationEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "treatment_body_id", referencedColumnName = "ID")
	private TreatmentBodyEntity treatmentBodyEntity;

	@Column(name = "ref_no_medicine")
	private String refnomedicine;

	@Column(name = "total_cost")
	private String totalCost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", referencedColumnName = "ID")
	private StatusEntity status;

	@Column(name = "collectDate")
	private Date collectDate;

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
