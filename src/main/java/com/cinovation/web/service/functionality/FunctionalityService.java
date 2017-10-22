package com.cinovation.web.service.functionality;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.functionality.FunctionalityEntity;

public interface FunctionalityService {
	
	Page<FunctionalityEntity> getFunctionalityTable(String filter1, String filter2, Pageable pageable);
	
	List<FunctionalityEntity> getFunctionalityList();
	
	FunctionalityEntity getFunctionalityListById(String ID);
	
	FunctionalityEntity getFunctionalityListByCd(String cd);
	
	FunctionalityEntity saveFunctionality(FunctionalityEntity dataContainer) throws Exception;
	
	FunctionalityEntity updateFunctionality(FunctionalityEntity dataContainer) throws Exception;
	
	List<FunctionalityEntity> getPositionEntityId(String ID);
	
	FunctionalityEntity deleteFunctionalityById(String ID) throws Exception;
	
}
