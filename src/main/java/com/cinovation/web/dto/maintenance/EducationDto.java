package com.cinovation.web.dto.maintenance;


import org.hibernate.validator.constraints.NotEmpty;

public class EducationDto {
	private String id;

	@NotEmpty
	private String education;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
