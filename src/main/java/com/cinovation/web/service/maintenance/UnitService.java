package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.UnitEntity;

public interface UnitService {
	
	Page<UnitEntity> getUnitTable(Pageable pageable);
	
	List<UnitEntity> getUnitList();
	
	UnitEntity getUnitListById(String ID);
	
	UnitEntity saveUnit(UnitEntity dataContainer) throws Exception;
	
	UnitEntity updateUnit(UnitEntity dataContainer) throws Exception;
	
	UnitEntity deleteUnitById(String ID) throws Exception;
}
