package com.cinovation.web.dto.patient;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.apoteker.MedicineEntity;
import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;
import com.cinovation.web.entity.patient.PatientMedicineEntity;
import com.cinovation.web.validator.custom.NumberValue;

public class PatientMedicineDetailsDto {

	private String id;

	@NotNull
	private PatientMedicineEntity patientMedicineEntity;

	@NotNull
	private MedicineEntity medicineEntity;

	@NotNull
	private MedicineUnitConverterEntity medicineUnitConverterEntity;

	@NotEmpty
	@NumberValue
	private String quantity;

	private String cost;

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

}
