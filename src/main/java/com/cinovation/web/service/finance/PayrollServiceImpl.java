package com.cinovation.web.service.finance;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.finance.PayrollEntity;
import com.cinovation.web.repository.finance.PayrollRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PayrollServiceImpl implements PayrollService {
	private static final Logger logger = Logger.getLogger(PayrollServiceImpl.class);
	
	@Autowired
	PayrollRepository payrollRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PayrollEntity> getPayrollTable(String filter1, String filter2, Pageable pageable) {
		return payrollRepository.findByForMonthAndForYearOrderByFunctionalityEntityNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<PayrollEntity> getPayrollList() {
		return payrollRepository.findAll();
	}
	
	@Override
	public PayrollEntity getPayrollListById(String ID) {
		return payrollRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PayrollEntity savePayroll(PayrollEntity dataContainer) throws Exception {
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return payrollRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PayrollEntity updatePayroll(PayrollEntity dataContainer) throws Exception {
		PayrollEntity data = payrollRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setSalary(dataContainer.getSalary());
		data.setExtraPay(dataContainer.getExtraPay());
		data.setForMonth(dataContainer.getForMonth());
		data.setForYear(dataContainer.getForYear());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return payrollRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PayrollEntity deletePayrollById(String ID) throws Exception {
		PayrollEntity data = payrollRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return payrollRepository.saveAndFlush(data);	
	}
}
