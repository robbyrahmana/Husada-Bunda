package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.IdentityEntity;

public interface IdentityService {
	Page<IdentityEntity> getIdentityTable(Pageable pageable);
	
	List<IdentityEntity> getIdentityList();
	
	IdentityEntity getIdentityListById(String ID);
	
	IdentityEntity saveIdentity(IdentityEntity dataContainer) throws Exception;
	
	IdentityEntity updateIdentity(IdentityEntity dataContainer) throws Exception;
	
	IdentityEntity deleteIdentityById(String ID) throws Exception;
}
