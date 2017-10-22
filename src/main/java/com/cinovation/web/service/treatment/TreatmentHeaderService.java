package com.cinovation.web.service.treatment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;

public interface TreatmentHeaderService {

	Page<TreatmentHeaderEntity> getTreatmentHeaderTable(String filter1, String filter2, Pageable pageable);
	
	List<TreatmentHeaderEntity> getTreatmentHeaderList();
	
	TreatmentHeaderEntity getTreatmentHeaderListById(String ID);
	
	TreatmentHeaderEntity saveTreatmentHeader(TreatmentHeaderEntity dataContainer) throws Exception;
	
	TreatmentHeaderEntity updateTreatmentHeader(TreatmentHeaderEntity dataContainer) throws Exception;
	
	TreatmentHeaderEntity deleteTreatmentHeaderById(String ID) throws Exception;
}
