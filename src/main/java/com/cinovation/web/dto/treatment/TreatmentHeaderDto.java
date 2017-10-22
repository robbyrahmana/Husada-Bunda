package com.cinovation.web.dto.treatment;

import org.hibernate.validator.constraints.NotEmpty;

public class TreatmentHeaderDto {

	private String ID;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

	private int showbody;

	@NotEmpty
	private String isChooseByUser;

	private String remark;

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

	public int getShowbody() {
		return showbody;
	}

	public void setShowbody(int showbody) {
		this.showbody = showbody;
	}

	public String getIsChooseByUser() {
		return isChooseByUser;
	}

	public void setIsChooseByUser(String isChooseByUser) {
		this.isChooseByUser = isChooseByUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
