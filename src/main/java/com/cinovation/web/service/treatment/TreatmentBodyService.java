package com.cinovation.web.service.treatment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.treatment.TreatmentBodyEntity;

public interface TreatmentBodyService {
	
	Page<TreatmentBodyEntity> getTreatmentBodyTable(String filter1, String filter2, Pageable pageable);
	
	List<TreatmentBodyEntity> getTreatmentBodyList();
	
	TreatmentBodyEntity getTreatmentBodyListById(String ID);
	
	TreatmentBodyEntity saveTreatmentBody(TreatmentBodyEntity dataContainer) throws Exception;
	
	TreatmentBodyEntity updateTreatmentBody(TreatmentBodyEntity dataContainer) throws Exception;
	
	TreatmentBodyEntity deleteTreatmentBodyById(String ID) throws Exception;
	
	List<TreatmentBodyEntity> getTreatmentBodyListByHeaderId(String ID);
	
	List<TreatmentBodyEntity> getTreatmentBodyListByProductId(String ID);
}
