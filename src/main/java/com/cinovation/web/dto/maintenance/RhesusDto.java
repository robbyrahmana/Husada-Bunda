package com.cinovation.web.dto.maintenance;


import org.hibernate.validator.constraints.NotEmpty;

public class RhesusDto {
	private String id;

	@NotEmpty
	private String rhesus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRhesus() {
		return rhesus;
	}

	public void setRhesus(String rhesus) {
		this.rhesus = rhesus;
	}

}
