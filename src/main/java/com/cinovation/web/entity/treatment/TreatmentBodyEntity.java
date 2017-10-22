package com.cinovation.web.entity.treatment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "TreatmentBody")
@Table(name = "t_treatment_body")
public class TreatmentBodyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2864158559886397828L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "treatment_header_id", referencedColumnName = "ID")
	private TreatmentHeaderEntity treatmentHeaderEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_product_id", referencedColumnName = "ID")
	private ProductEntity productEntity;

	@Column(name = "cd")
	private String cd;

	@Column(name = "name")
	private String name;

	@Column(name = "cost")
	private String cost;

	@Column(name = "doktercost")
	private String doktercost;

	@Column(name = "remark")
	private String remark;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "updateDate")
	private Date updateDate;

	@Column(name = "isDel")
	private int isDel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TreatmentHeaderEntity getTreatmentHeaderEntity() {
		return treatmentHeaderEntity;
	}

	public void setTreatmentHeaderEntity(
			TreatmentHeaderEntity treatmentHeaderEntity) {
		this.treatmentHeaderEntity = treatmentHeaderEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
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

	public String getDoktercost() {
		return doktercost;
	}

	public void setDoktercost(String doktercost) {
		this.doktercost = doktercost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

}
