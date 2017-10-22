package com.cinovation.web.service.functionality;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.functionality.DeseaseEntity;

public interface DeseaseService {

	Page<DeseaseEntity> getDeseaseTable(String filter1, String filter2, Pageable pageable);
	
	List<DeseaseEntity> getDeseaseList();
	
	DeseaseEntity getDeseaseListById(String ID);
	
	DeseaseEntity saveDesease(DeseaseEntity dataContainer) throws Exception;
	
	DeseaseEntity updateDesease(DeseaseEntity dataContainer) throws Exception;
	
	DeseaseEntity deleteDeseaseById(String ID) throws Exception;
}
