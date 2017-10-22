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

import com.cinovation.web.entity.functionality.FunctionalityEntity;

@Entity(name = "PatientOperationEntity")
@Table(name = "t_patient_operation")
public class PatientOperationEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3891949336380547705L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_administration_id", referencedColumnName = "ID")
	private PatientAdministrationEntity patientAdministrationEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "functionality_id", referencedColumnName = "ID")
	private FunctionalityEntity functionalityEntity;

	@Column(name = "remark")
	private String remark;

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
