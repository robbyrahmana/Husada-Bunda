package com.cinovation.web.dto.maintenance;


import org.hibernate.validator.constraints.NotEmpty;

public class IdentityDto {
	private String id;

	@NotEmpty
	private String identity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
}
