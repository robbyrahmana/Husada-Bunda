package com.cinovation.web.entity.finance;

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

import com.cinovation.web.entity.functionality.FunctionalityEntity;

@Entity(name = "PayrollEntity")
@Table(name = "t_payroll")
public class PayrollEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2521506076406806607L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true)
	private String id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "functionality_id", referencedColumnName = "ID")
	private FunctionalityEntity functionalityEntity;

	@Column(name = "salary")
	private String salary;

	@Column(name = "extraPay")
	private String extraPay;

	@Column(name = "forMonth")
	private String forMonth;

	@Column(name = "forYear")
	private String forYear;

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

	public FunctionalityEntity getFunctionalityEntity() {
		return functionalityEntity;
	}

	public void setFunctionalityEntity(FunctionalityEntity functionalityEntity) {
		this.functionalityEntity = functionalityEntity;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getExtraPay() {
		return extraPay;
	}

	public void setExtraPay(String extraPay) {
		this.extraPay = extraPay;
	}

	public String getForMonth() {
		return forMonth;
	}

	public void setForMonth(String forMonth) {
		this.forMonth = forMonth;
	}

	public String getForYear() {
		return forYear;
	}

	public void setForYear(String forYear) {
		this.forYear = forYear;
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
