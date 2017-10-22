package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.WorkEntity;

public interface WorkService {
	Page<WorkEntity> getWorkTable(Pageable pageable);
	
	List<WorkEntity> getWorkList();
	
	WorkEntity getWorkListById(String ID);
	
	WorkEntity saveWork(WorkEntity dataContainer) throws Exception;
	
	WorkEntity updateWork(WorkEntity dataContainer) throws Exception;
	
	WorkEntity deleteWorkById(String ID) throws Exception;
}
