package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.GenderEntity;

public interface GenderService {
	
	Page<GenderEntity> getGenderTable(Pageable pageable);
	
	List<GenderEntity> getGenderList();
	
	GenderEntity getGenderListById(String ID);
	
	GenderEntity saveGender(GenderEntity dataContainer) throws Exception;
	
	GenderEntity updateGender(GenderEntity dataContainer) throws Exception;
	
	GenderEntity deleteGenderById(String ID) throws Exception;
}
