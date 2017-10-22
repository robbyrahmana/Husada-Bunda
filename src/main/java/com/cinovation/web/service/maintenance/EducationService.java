package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.EducationEntity;

public interface EducationService {
	Page<EducationEntity> getEducationTable(Pageable pageable);
	
	List<EducationEntity> getEducationList();
	
	EducationEntity getEducationListById(String ID);
	
	EducationEntity saveEducation(EducationEntity dataContainer) throws Exception;
	
	EducationEntity updateEducation(EducationEntity dataContainer) throws Exception;
	
	EducationEntity deleteEducationById(String ID) throws Exception;
}
