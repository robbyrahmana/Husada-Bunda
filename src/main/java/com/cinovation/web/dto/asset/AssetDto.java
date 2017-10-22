package com.cinovation.web.dto.asset;

import java.util.Date;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.asset.AssetGroupEntity;

public class AssetDto {
	private String id;

	@NotEmpty
	private String cd;

	@NotEmpty
	private String name;

	@NotNull
	private AssetGroupEntity assetGroupEntity;

	private String price;

	private Date getDate;

	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public AssetGroupEntity getAssetGroupEntity() {
		return assetGroupEntity;
	}

	public void setAssetGroupEntity(AssetGroupEntity assetGroupEntity) {
		this.assetGroupEntity = assetGroupEntity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
