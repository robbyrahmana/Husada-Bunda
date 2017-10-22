package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.BloodGroupEntity;

public interface BloodGroupService {

	Page<BloodGroupEntity> getBloodGroupTable(Pageable pageable);
	
	List<BloodGroupEntity> getBloodGroupList();
	
	BloodGroupEntity getBloodGroupListById(String ID);
	
	BloodGroupEntity saveBloodGroup(BloodGroupEntity dataContainer) throws Exception;
	
	BloodGroupEntity updateBloodGroup(BloodGroupEntity dataContainer) throws Exception;
	
	BloodGroupEntity deleteBloodGroupById(String ID) throws Exception;
}
