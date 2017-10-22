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

import com.cinovation.web.entity.patient.PatientMedicineDetailsEntity;
import com.cinovation.web.repository.apoteker.MedicineRepository;
import com.cinovation.web.repository.apoteker.MedicineUnitConverterRepository;
import com.cinovation.web.repository.patient.PatientMedicineDetailsRepository;
import com.cinovation.web.repository.patient.PatientMedicineRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.apoteker.MedicineService;
import com.cinovation.web.service.apoteker.MedicineUnitConverterService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class PatientMedicineDetailsServiceImpl implements PatientMedicineDetailsService{

	private static final Logger logger = Logger.getLogger(PatientMedicineDetailsServiceImpl.class);
	
	@Autowired
	PatientMedicineDetailsRepository patientMedicineDetailsRepository;
	
	@Inject
	PatientMedicineService patientMedicineService;
	
	@Inject
	MedicineService medicineService;
	
	@Inject
	MedicineUnitConverterService medicineUnitConverterService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<PatientMedicineDetailsEntity> getPatientMedicineDetailsTable(String filter1, Pageable pageable) {
		logger.info("");
		return patientMedicineDetailsRepository.findByPatientMedicineEntityIdContainingOrderByCreateDateDesc(filter1, pageable);
	}
	
	@Override
	@Transactional
	public List<PatientMedicineDetailsEntity> getPatientMedicineDetailsList() {
		return patientMedicineDetailsRepository.findAll();
	}
	
	@Override
	@Transactional
	public PatientMedicineDetailsEntity getPatientMedicineDetailsListById(String ID) {
		return patientMedicineDetailsRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public PatientMedicineDetailsEntity savePatientMedicineDetails(PatientMedicineDetailsEntity dataContainer) throws Exception {
		
		dataContainer.setCost(dataContainer.getMedicineUnitConverterEntity().getPrice());
		
		patientMedicineService.updatePatientMedicineTotalSumGroupByMedicine(
				dataContainer.getPatientMedicineEntity().getId(), 
				"0", 
				helperService.multiply(dataContainer.getCost(), dataContainer.getQuantity())
		);
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return patientMedicineDetailsRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientMedicineDetailsEntity updatePatientMedicineDetails(PatientMedicineDetailsEntity dataContainer) throws Exception {
		PatientMedicineDetailsEntity data = patientMedicineDetailsRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		patientMedicineService.updatePatientMedicineTotalSumGroupByMedicine(
				data.getPatientMedicineEntity().getId(), 
				helperService.multiply(data.getCost(), data.getQuantity()), 
				helperService.multiply(dataContainer.getCost(), dataContainer.getQuantity())
		);
		
		data.setMedicineEntity(medicineService.getMedicineListById(dataContainer.getMedicineEntity().getId()));
		data.setMedicineUnitConverterEntity(medicineUnitConverterService.getMedicineUnitConverterListById(dataContainer.getMedicineUnitConverterEntity().getId()));
		data.setCost(dataContainer.getMedicineUnitConverterEntity().getPrice());
		data.setQuantity(dataContainer.getQuantity());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return patientMedicineDetailsRepository.saveAndFlush(data);	
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public PatientMedicineDetailsEntity deletePatientMedicineDetailsById(String ID) throws Exception {
		PatientMedicineDetailsEntity data = patientMedicineDetailsRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return patientMedicineDetailsRepository.saveAndFlush(data);	
	}
}
