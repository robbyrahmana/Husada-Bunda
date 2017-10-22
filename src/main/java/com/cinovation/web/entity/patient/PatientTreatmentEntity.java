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
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.entity.treatment.TreatmentBodyEntity;
import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;

@Entity(name = "PatientTreatmentEntity")
@Table(name = "t_patient_treatment")
public class PatientTreatmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7776320266817292800L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_administration_id", referencedColumnName = "ID")
	private PatientAdministrationEntity patientAdministrationEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "treatment_header_id", referencedColumnName = "ID")
	private TreatmentHeaderEntity treatmentHeaderEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "treatment_body_id", referencedColumnName = "ID")
	private TreatmentBodyEntity treatmentBodyEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "functionality_id", referencedColumnName = "ID")
	private FunctionalityEntity functionalityEntity;

	@Column(name = "cost")
	private String cost;

	@Column(name = "doktercost")
	private String doktercost;

	@Column(name = "remark")
	private String remark;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", referencedColumnName = "ID")
	private StatusEntity status;

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
