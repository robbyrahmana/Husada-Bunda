package com.cinovation.web.service.functionality;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.functionality.SMFEntity;

public interface SMFService {

	Page<SMFEntity> getSMFTable(String filter1, String filter2, Pageable pageable);
	
	List<SMFEntity> getSMFList();
	
	SMFEntity getSMFListById(String ID);
	
	SMFEntity saveSMF(SMFEntity dataContainer) throws Exception;
	
	SMFEntity updateSMF(SMFEntity dataContainer) throws Exception;
	
	SMFEntity deleteSMFById(String ID) throws Exception;
}
