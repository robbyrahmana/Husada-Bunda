package com.cinovation.web.entity.apoteker;

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

import com.cinovation.web.entity.maintenance.UnitEntity;

@Entity(name = "MedicineUnitConverterEntity")
@Table(name = "t_medicine_unit_converter")
public class MedicineUnitConverterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -466867156988947819L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medicine_id", referencedColumnName = "ID")
	private MedicineEntity medicineEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "convert_unit_id", referencedColumnName = "ID")
	private UnitEntity unitEntity;

	@Column(name = "price")
	private String price;

	@Column(name = "quantity")
	private String quantity;

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

	public MedicineEntity getMedicineEntity() {
		return medicineEntity;
	}

	public void setMedicineEntity(MedicineEntity medicineEntity) {
		this.medicineEntity = medicineEntity;
	}

	public UnitEntity getUnitEntity() {
		return unitEntity;
	}

	public void setUnitEntity(UnitEntity unitEntity) {
		this.unitEntity = unitEntity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
