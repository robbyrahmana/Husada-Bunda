package com.cinovation.web.dto.maintenance;

import org.hibernate.validator.constraints.NotEmpty;

public class RelationshipDto {
	private String id;

	@NotEmpty
	private String relationship;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
