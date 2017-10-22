package com.cinovation.web.service.patient;

import java.util.Date;
import java.util.List;


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
import com.cinovation.web.entity.patient.PatientMedicineEntity;
import com.cinovation.web.repository.StatusRepository;
import com.cinovation.web.repository.patient.PatientMedicineRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientMedicineServiceImpl implements PatientMedicineService{

	private static final Logger logger = Logger.getLogger(PatientMedicineServiceImpl.class);
	
	@Autowired
	PatientMedicineRepository patientMedicineRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<PatientMedicineEntity> getPatientMedicineTable(String filter1, String filter2, String filter3, String filter4, Pageable pageable) {
		logger.info(filter4);
		if (filter4.equalsIgnoreCase(ApplicationConstants.ALL_RECORD)) {
			return patientMedicineRepository.findByRefnomedicineContainingAndPatientAdministrationEntityPatientEntityRefnopatientContainingAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc(filter1, filter2, filter3, pageable);
		} else {
			return patientMedicineRepository.findByPatientAdministrationEntityIdOrderByCreateDateDesc(filter4, pageable);
		}
		
	}
	
	@Override
	public Page<PatientMedicineEntity> getPatientMedicineTableByStatusId(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return patientMedicineRepository.findByStatusIdAndPatientAdministrationEntityPatientEntityNameContainingOrderByCreateDateDesc(filter1, filter2, pageable);
	}
	
	@Override
	public List<PatientMedicineEntity> getPatientMedicineList() {
		return patientMedicineRepository.findAll();
	}
	
	@Override
	public PatientMedicineEntity getPatientMedicineListById(String ID) {
		return patientMedicineRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientMedicineEntity savePatientMedicine(PatientMedicineEntity dataContainer) throws Exception {
		
		dataContainer.setRefnomedicine(helperService.getMedicineCode(dataContainer.getPatientAdministrationEntity().getPatientEntity().getRefnopatient()));
		dataContainer.setTotalCost("0");
		dataContainer.setStatus(statusRepository.findByCd(ApplicationConstants.STATUS_NEW));
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return patientMedicineRepository.saveAndFlush(dataContainer);
	}
	
	@Override
	public void updatePatientMedicineTotalSumGroupByMedicine(String ID, String old_data, String new_data) {
		PatientMedicineEntity data = patientMedicineRepository.findOne(ID);
		
		String currentCost = data.getTotalCost();
		String newCost = "0";
		newCost = helperService.minus(currentCost, old_data);
		newCost = helperService.plus(newCost, new_data);
		
		data.setTotalCost(newCost);
		
		patientMedicineRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientMedicineEntity deletePatientMedicineById(String ID) throws Exception {
		PatientMedicineEntity data = patientMedicineRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientMedicineRepository.saveAndFlush(data);	
	}
	
	@Override
	public PatientMedicineEntity updateStatusById(String id) throws Exception {
		PatientMedicineEntity data = patientMedicineRepository.findOne(id);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setStatus(statusRepository.findByCd(ApplicationConstants.STATUS_COLLECTED));
		
		data.setCollectDate(helperService.setDateFormat(new Date()));
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return patientMedicineRepository.saveAndFlush(data);
	}
}
