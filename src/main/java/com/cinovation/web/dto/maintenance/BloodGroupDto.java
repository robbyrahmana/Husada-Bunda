package com.cinovation.web.dto.maintenance;

import org.hibernate.validator.constraints.NotEmpty;

public class BloodGroupDto {

	private String id;

	@NotEmpty
	private String bloodgroup;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	@Override
	public String toString() {
		return 	  "{"
				+ "bloodgroup: "+ bloodgroup 
				+"}";
	}

}
