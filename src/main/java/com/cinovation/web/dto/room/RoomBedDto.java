package com.cinovation.web.dto.room;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.room.RoomDetailEntity;

public class RoomBedDto {

	private String ID;

	@NotEmpty
	private String cd;

	@NotNull
	private RoomDetailEntity roomDetailEntity;

	private String dscp;

	private int isAvailable;

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

	public RoomDetailEntity getRoomDetailEntity() {
		return roomDetailEntity;
	}

	public void setRoomDetailEntity(RoomDetailEntity roomDetailEntity) {
		this.roomDetailEntity = roomDetailEntity;
	}

	public String getDscp() {
		return dscp;
	}

	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

}
