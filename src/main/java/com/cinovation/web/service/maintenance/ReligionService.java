package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.ReligionEntity;

public interface ReligionService {
	Page<ReligionEntity> getReligionTable(Pageable pageable);
	
	List<ReligionEntity> getReligionList();
	
	ReligionEntity getReligionListById(String ID);
	
	ReligionEntity saveReligion(ReligionEntity dataContainer) throws Exception;
	
	ReligionEntity updateReligion(ReligionEntity dataContainer) throws Exception;
	
	ReligionEntity deleteReligionById(String ID) throws Exception;
}
