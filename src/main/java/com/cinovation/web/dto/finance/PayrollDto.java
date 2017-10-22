package com.cinovation.web.dto.finance;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.cinovation.web.entity.functionality.FunctionalityEntity;

public class PayrollDto {

	private String id;

	@NotNull
	private FunctionalityEntity functionalityEntity;

	@NotEmpty
	private String salary;

	private String extraPay;

	@NotEmpty
	private String forMonth;

	@NotEmpty
	private String forYear;

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

}
