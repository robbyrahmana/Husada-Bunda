package com.cinovation.web.service.finance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.finance.PayrollEntity;

public interface PayrollService {
	Page<PayrollEntity> getPayrollTable(String filter1, String filter2, Pageable pageable);
	
	List<PayrollEntity> getPayrollList();
	
	PayrollEntity getPayrollListById(String ID);
	
	PayrollEntity savePayroll(PayrollEntity dataContainer) throws Exception;
	
	PayrollEntity updatePayroll(PayrollEntity dataContainer) throws Exception;
	
	PayrollEntity deletePayrollById(String ID) throws Exception;
}
