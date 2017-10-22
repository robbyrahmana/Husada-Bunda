package com.cinovation.web.dto.functionality;

import org.hibernate.validator.constraints.NotEmpty;

public class SMFDto {

	private String id;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
