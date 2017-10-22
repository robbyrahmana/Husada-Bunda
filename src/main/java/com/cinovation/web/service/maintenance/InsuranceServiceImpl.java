package com.cinovation.web.service.maintenance;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.repository.maintenance.InsuranceRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class InsuranceServiceImpl implements InsuranceService{
	
	private static final Logger logger = Logger.getLogger(InsuranceServiceImpl.class);
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Cacheable(value="CacheInsurance")
	public Page<InsuranceEntity> getInsuranceTable(Pageable pageable) {
		logger.info("");
		return insuranceRepository.findByOrderByInsuranceAsc(pageable);
	}
	
	@Override
	@Cacheable(value="CacheInsurance")
	public List<InsuranceEntity> getInsuranceList() {
		return insuranceRepository.findAll();
	}
	
	@Override
	@Cacheable(value="CacheInsurance", key="#ID")
	public InsuranceEntity getInsuranceListById(String ID) {
		return insuranceRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	@CacheEvict(value="CacheInsurance", allEntries=true)
	public InsuranceEntity saveInsurance(InsuranceEntity dataContainer) throws Exception {
		InsuranceEntity duplicate = insuranceRepository.findByInsurance(dataContainer.getInsurance());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return insuranceRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	@CacheEvict(value="CacheInsurance", allEntries=true)
	public InsuranceEntity updateInsurance(InsuranceEntity dataContainer) throws Exception {
		InsuranceEntity data = insuranceRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setInsurance(dataContainer.getInsurance());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return insuranceRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public InsuranceEntity deleteInsuranceById(String ID) throws Exception {
		InsuranceEntity data = insuranceRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return insuranceRepository.saveAndFlush(data);	
	}
}
