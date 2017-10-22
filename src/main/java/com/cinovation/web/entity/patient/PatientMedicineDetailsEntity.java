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

import com.cinovation.web.entity.apoteker.MedicineEntity;
import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;

@Entity(name = "PatientMedicineDetailsEntity")
@Table(name = "t_patient_medicine_details")
public class PatientMedicineDetailsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6537660964142606610L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_medicine_id", referencedColumnName = "ID")
	private PatientMedicineEntity patientMedicineEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medicine_id", referencedColumnName = "ID")
	private MedicineEntity medicineEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medicine_unit_converter_id", referencedColumnName = "ID")
	private MedicineUnitConverterEntity medicineUnitConverterEntity;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "cost")
	private String cost;

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

	public PatientMedicineEntity getPatientMedicineEntity() {
		return patientMedicineEntity;
	}

	public void setPatientMedicineEntity(
			PatientMedicineEntity patientMedicineEntity) {
		this.patientMedicineEntity = patientMedicineEntity;
	}

	public MedicineEntity getMedicineEntity() {
		return medicineEntity;
	}

	public void setMedicineEntity(MedicineEntity medicineEntity) {
		this.medicineEntity = medicineEntity;
	}

	public MedicineUnitConverterEntity getMedicineUnitConverterEntity() {
		return medicineUnitConverterEntity;
	}

	public void setMedicineUnitConverterEntity(
			MedicineUnitConverterEntity medicineUnitConverterEntity) {
		this.medicineUnitConverterEntity = medicineUnitConverterEntity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
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
