package com.cinovation.web.service.patient;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.patient.PatientEntity;
import com.cinovation.web.repository.patient.PatientRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.maintenance.BloodGroupService;
import com.cinovation.web.service.maintenance.EducationService;
import com.cinovation.web.service.maintenance.GenderService;
import com.cinovation.web.service.maintenance.IdentityService;
import com.cinovation.web.service.maintenance.InsuranceService;
import com.cinovation.web.service.maintenance.RelationshipService;
import com.cinovation.web.service.maintenance.ReligionService;
import com.cinovation.web.service.maintenance.RhesusService;
import com.cinovation.web.service.maintenance.TitleService;
import com.cinovation.web.service.maintenance.TribeService;
import com.cinovation.web.service.maintenance.WorkService;
import com.cinovation.web.service.room.RoomCategoryService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientServiceImpl implements PatientService{

	private static final Logger logger = Logger.getLogger(PatientServiceImpl.class);
	
	@Autowired
	PatientRepository patientRepository;
	
	@Inject
	TitleService titleService;
	
	@Inject
	GenderService genderService;
	
	@Inject
	ReligionService religionService;
	
	@Inject
	BloodGroupService bloodGroupService;
	
	@Inject
	InsuranceService insuranceService;
	
	@Inject
	RelationshipService relationshipService;
	
	@Inject
	EducationService educationService;
	
	@Inject
	IdentityService identityService;
	
	@Inject
	RhesusService rhesusService;
	
	@Inject
	TribeService tribeService;
	
	@Inject
	WorkService workService;
	
	@Inject
	RoomCategoryService roomCategoryService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PatientEntity> getPatientTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return patientRepository.findByRefnopatientContainingAndNameContainingOrderByCreateDateDesc(filter1, filter2, pageable);
	}
	
	@Override
	public List<PatientEntity> getPatientList() {
		return patientRepository.findAll();
	}
	
	@Override
	public PatientEntity getPatientListById(String ID) {
		return patientRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientEntity savePatient(PatientEntity dataContainer) throws Exception {
		PatientEntity duplicate = patientRepository.findByName(dataContainer.getIdentitynumber());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setRefnopatient(helperService.getPasienCode());
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return patientRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientEntity updatePatient(PatientEntity dataContainer) throws Exception {
		PatientEntity data = patientRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setTitleEntity(titleService.getTitleListById(dataContainer.getTitleEntity().getId()));
		data.setName(dataContainer.getName());
		data.setGenderEntity(genderService.getGenderListById(dataContainer.getGenderEntity().getId()));
		if (dataContainer.getRelationshipEntity() != null) data.setRelationshipEntity(relationshipService.getRelationshipListById(dataContainer.getRelationshipEntity().getId()));
		data.setRelationshipname(dataContainer.getRelationshipname());
		data.setParentname(dataContainer.getParentname());
		data.setBirthplace(dataContainer.getBirthplace());
		data.setBirthday(dataContainer.getBirthday());
		if (dataContainer.getEducationEntity() != null) data.setEducationEntity(educationService.getEducationListById(dataContainer.getEducationEntity().getId()));
		if (dataContainer.getBloodGroupEntity() != null) data.setBloodGroupEntity(bloodGroupService.getBloodGroupListById(dataContainer.getBloodGroupEntity().getId()));
		if (dataContainer.getRhesusEntity() != null) data.setRhesusEntity(rhesusService.getRhesusListById(dataContainer.getRhesusEntity().getId()));
		data.setNationality(dataContainer.getNationality());
		if (dataContainer.getWorkEntity() != null) data.setWorkEntity(workService.getWorkListById(dataContainer.getWorkEntity().getId()));
		if (dataContainer.getIdentityEntity() != null) data.setIdentityEntity(identityService.getIdentityListById(dataContainer.getIdentityEntity().getId()));
		data.setIdentitynumber(dataContainer.getIdentitynumber());
		if (dataContainer.getReligionEntity() != null) data.setReligionEntity(religionService.getReligionListById(dataContainer.getReligionEntity().getId()));
		if (dataContainer.getTribeEntity() != null) data.setTribeEntity(tribeService.getTribeListById(dataContainer.getTribeEntity().getId()));
		/*address*/
		data.setAddrline1(dataContainer.getAddrline1());
		data.setAddrline2(dataContainer.getAddrline2());
		data.setAddrline3(dataContainer.getAddrline3());
		data.setAddrline4(dataContainer.getAddrline4());
		data.setAddrline5(dataContainer.getAddrline5());
		data.setPostcode(dataContainer.getPostcode());
		data.setMobilenumber(dataContainer.getMobilenumber());
		if (dataContainer.getRoomCategoryEntity() != null) data.setRoomCategoryEntity(roomCategoryService.getRoomCategoryListById(dataContainer.getRoomCategoryEntity().getId()));
		if (dataContainer.getInsuranceEntity() != null) data.setInsuranceEntity(insuranceService.getInsuranceListById(dataContainer.getInsuranceEntity().getId()));
		data.setInsurancenumber(dataContainer.getInsurancenumber());
		/*emergency*/
		data.setEmergencyname(dataContainer.getEmergencyname());
		data.setEmergencymobilenumber(dataContainer.getEmergencymobilenumber());
		data.setEmergencyaddress(dataContainer.getEmergencyaddress());
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return patientRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientEntity deletePatientById(String ID) throws Exception {
		PatientEntity data = patientRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientRepository.saveAndFlush(data);	
	}
}
