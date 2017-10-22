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

import com.cinovation.web.constant.ApplicationConstants;
import com.cinovation.web.entity.patient.PatientAdministrationEntity;
import com.cinovation.web.entity.patient.PatientEntity;
import com.cinovation.web.repository.StatusRepository;
import com.cinovation.web.repository.patient.PatientAdministrationRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.room.RoomBedService;
import com.cinovation.web.service.room.RoomDetailService;
import com.cinovation.web.service.treatment.TreatmentBodyService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientAdministrationServiceImpl implements PatientAdministrationService{
	
	private static final Logger logger = Logger.getLogger(PatientAdministrationServiceImpl.class);
	
	@Autowired
	PatientAdministrationRepository patientAdministrationRepository;
	
	@Inject
	PatientService patientService;
	
	@Inject
	StatusRepository statusRepository;
	
	@Inject
	RoomDetailService roomDetailService;
	
	@Inject
	TreatmentBodyService treatmentBodyService;
	
	@Inject
	RoomBedService roomBedService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PatientAdministrationEntity> getPatientAdministrationTable(String filter1, String filter2, String filter3, Pageable pageable) {
		logger.info("");
		return patientAdministrationRepository.findByPatientEntityRefnopatientContainingAndPatientEntityNameContainingAndInternalstatusCdContainingOrderByCreateDateAsc(filter1, filter2, filter3, pageable);
	}
	
	@Override
	public Page<PatientAdministrationEntity> getPatientAdministrationTableByDokterId(String filter1, Pageable pageable) {
		logger.info("");
		return patientAdministrationRepository.findByFunctionalityEntityIdOrderByCreateDateAsc(filter1, pageable);
	}
	
	@Override
	public List<PatientAdministrationEntity> getPatientAdministrationList() {
		return patientAdministrationRepository.findAll();
	}
	
	@Override
	public PatientAdministrationEntity getPatientAdministrationListById(String ID) {
		return patientAdministrationRepository.findOne(ID);
	}
	
	@Override
	public String getRegistrationCode(String ID) {
		PatientEntity data = patientService.getPatientListById(ID);
		return helperService.getRegistrasiCode(data.getRefnopatient());
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientAdministrationEntity savePatientAdministration(PatientAdministrationEntity dataContainer) throws Exception {
		
		dataContainer.setRefnoadministrations(this.getRegistrationCode(dataContainer.getPatientEntity().getId()));
		
		dataContainer.setInDate(helperService.setDateFormat(new Date()));
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		if (dataContainer.getRoomBedEntity() != null) dataContainer.setRoomDetailEntity(roomDetailService.getRoomDetailListById(dataContainer.getRoomBedEntity().getRoomDetailEntity().getId()));
		
		//update room available to false 
		if (dataContainer.getAdminoption().equals("1") && dataContainer.getRoomBedEntity() != null) {
			roomBedService.updateRoomBedAvailableById(dataContainer.getRoomBedEntity().getId());
		}
		
		dataContainer.setCost(treatmentBodyService.getTreatmentBodyListById(ApplicationConstants.TREATMENT_BODY_ADMINISTRASI).getCost());
		
		dataContainer.setInternalstatus(statusRepository.findByCd(ApplicationConstants.STATUS_OPEN));
		
		return patientAdministrationRepository.saveAndFlush(dataContainer);
	}
	
	@Override
	public PatientAdministrationEntity updateStatusById(String id) throws Exception {
		PatientAdministrationEntity data = patientAdministrationRepository.findOne(id);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setInternalstatus(statusRepository.findByCd(ApplicationConstants.STATUS_COMPLETE));
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));

		data.setOutDate(helperService.setDateFormat(new Date()));
		
		return patientAdministrationRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientAdministrationEntity deletePatientAdministrationById(String ID, String remark) throws Exception {
		PatientAdministrationEntity data = patientAdministrationRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setIsDel(1);
		data.setDelRemark(remark);
		
		return patientAdministrationRepository.saveAndFlush(data);	
	}
}
