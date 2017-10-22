package com.cinovation.web.dto.maintenance;

import org.hibernate.validator.constraints.NotEmpty;

public class GenderDto {

	private String id;

	@NotEmpty
	private String gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
