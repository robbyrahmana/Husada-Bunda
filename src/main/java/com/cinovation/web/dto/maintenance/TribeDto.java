package com.cinovation.web.dto.maintenance;

import org.hibernate.validator.constraints.NotEmpty;

public class TribeDto {
	private String id;

	@NotEmpty
	private String tribe;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTribe() {
		return tribe;
	}

	public void setTribe(String tribe) {
		this.tribe = tribe;
	}

}
