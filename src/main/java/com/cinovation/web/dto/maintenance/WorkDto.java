package com.cinovation.web.dto.maintenance;


import org.hibernate.validator.constraints.NotEmpty;

public class WorkDto {
	private String id;

	@NotEmpty
	private String work;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

}
