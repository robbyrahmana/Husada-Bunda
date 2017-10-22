package com.cinovation.web.dto.room;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.room.RoomCategoryEntity;
import com.cinovation.web.validator.custom.NumberValue;

public class RoomDetailDto {

	String ID;

	@NotEmpty
	String cd;

	@NotEmpty
	String name;

	@NotEmpty
	@NumberValue
	String cost;

	String dscp;

	@NotNull
	RoomCategoryEntity roomCategoryEntity;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDscp() {
		return dscp;
	}

	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public RoomCategoryEntity getRoomCategoryEntity() {
		return roomCategoryEntity;
	}

	public void setRoomCategoryEntity(RoomCategoryEntity roomCategoryEntity) {
		this.roomCategoryEntity = roomCategoryEntity;
	}

}
