package com.cinovation.web.service.functionality;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.functionality.PositionEntity;

public interface PositionService {

	Page<PositionEntity> getPositionTable(String filter1, String filter2, Pageable pageable);
	
	List<PositionEntity> getPositionList();
	
	PositionEntity getPositionListById(String ID);
	
	PositionEntity savePosition(PositionEntity dataContainer) throws Exception;
	
	PositionEntity updatePosition(PositionEntity dataContainer) throws Exception;
	
	PositionEntity deletePositionById(String ID) throws Exception;
}
