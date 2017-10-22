package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.InsuranceEntity;

public interface InsuranceService {

	Page<InsuranceEntity> getInsuranceTable(Pageable pageable);
	
	List<InsuranceEntity> getInsuranceList();
	
	InsuranceEntity getInsuranceListById(String ID);
	
	InsuranceEntity saveInsurance(InsuranceEntity dataContainer) throws Exception;
	
	InsuranceEntity updateInsurance(InsuranceEntity dataContainer) throws Exception;
	
	InsuranceEntity deleteInsuranceById(String ID) throws Exception;
}
