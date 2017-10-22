package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.RhesusEntity;

public interface RhesusService {
	Page<RhesusEntity> getRhesusTable(Pageable pageable);
	
	List<RhesusEntity> getRhesusList();
	
	RhesusEntity getRhesusListById(String ID);
	
	RhesusEntity saveRhesus(RhesusEntity dataContainer) throws Exception;
	
	RhesusEntity updateRhesus(RhesusEntity dataContainer) throws Exception;
	
	RhesusEntity deleteRhesusById(String ID) throws Exception;
}
