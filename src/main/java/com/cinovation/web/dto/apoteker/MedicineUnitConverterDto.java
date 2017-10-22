package com.cinovation.web.dto.apoteker;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.apoteker.MedicineEntity;
import com.cinovation.web.entity.maintenance.UnitEntity;
import com.cinovation.web.validator.custom.NumberValue;

public class MedicineUnitConverterDto {

	private String id;

	@NotNull
	private MedicineEntity medicineEntity;

	@NotNull
	private UnitEntity unitEntity;

	@NotEmpty
	@NumberValue
	private String quantity;

	@NotEmpty
	@NumberValue
	private String price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MedicineEntity getMedicineEntity() {
		return medicineEntity;
	}

	public void setMedicineEntity(MedicineEntity medicineEntity) {
		this.medicineEntity = medicineEntity;
	}

	public UnitEntity getUnitEntity() {
		return unitEntity;
	}

	public void setUnitEntity(UnitEntity unitEntity) {
		this.unitEntity = unitEntity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
