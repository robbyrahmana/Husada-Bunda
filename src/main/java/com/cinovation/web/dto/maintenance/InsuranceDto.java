package com.cinovation.web.dto.maintenance;

import org.hibernate.validator.constraints.NotEmpty;

public class InsuranceDto {

	private String id;

	@NotEmpty
	private String insurance;

	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
