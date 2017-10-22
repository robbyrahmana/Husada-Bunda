package com.cinovation.web.dto.apoteker;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.maintenance.UnitEntity;

public class MedicineDto {

	private String id;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

	@NotNull
	private UnitEntity unitEntity;

	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UnitEntity getUnitEntity() {
		return unitEntity;
	}

	public void setUnitEntity(UnitEntity unitEntity) {
		this.unitEntity = unitEntity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
