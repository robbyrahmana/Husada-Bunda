package com.cinovation.web.dto.treatment;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.treatment.ProductEntity;
import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;

public class TreatmentBodyDto {

	private String ID;

	@NotNull
	private TreatmentHeaderEntity treatmentHeaderEntity;

	@NotNull
	private ProductEntity productEntity;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

	private String cost;

	private String doktercost;

	private String remark;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public TreatmentHeaderEntity getTreatmentHeaderEntity() {
		return treatmentHeaderEntity;
	}

	public void setTreatmentHeaderEntity(
			TreatmentHeaderEntity treatmentHeaderEntity) {
		this.treatmentHeaderEntity = treatmentHeaderEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
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

}
