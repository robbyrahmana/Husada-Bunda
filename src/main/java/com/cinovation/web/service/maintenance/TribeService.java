package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.TribeEntity;

public interface TribeService {
	Page<TribeEntity> getTribeTable(Pageable pageable);
	
	List<TribeEntity> getTribeList();
	
	TribeEntity getTribeListById(String ID);
	
	TribeEntity saveTribe(TribeEntity dataContainer) throws Exception;
	
	TribeEntity updateTribe(TribeEntity dataContainer) throws Exception;
	
	TribeEntity deleteTribeById(String ID) throws Exception;
}
