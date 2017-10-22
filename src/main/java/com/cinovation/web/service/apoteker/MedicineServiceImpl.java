package com.cinovation.web.service.apoteker;

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

import com.cinovation.web.entity.apoteker.MedicineEntity;
import com.cinovation.web.repository.apoteker.MedicineRepository;
import com.cinovation.web.repository.maintenance.UnitRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.maintenance.UnitService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class MedicineServiceImpl implements MedicineService{
	
	private static final Logger logger = Logger.getLogger(MedicineServiceImpl.class);
	
	@Autowired
	MedicineRepository medicineRepository;
	
	@Inject
	UnitService unitService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<MedicineEntity> getMedicineTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return medicineRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<MedicineEntity> getMedicineList() {
		return medicineRepository.findAll();
	}
	
	@Override
	public MedicineEntity getMedicineListById(String ID) {
		return medicineRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public MedicineEntity saveMedicine(MedicineEntity dataContainer) throws Exception {
		MedicineEntity duplicate = medicineRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return medicineRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public MedicineEntity updateMedicine(MedicineEntity dataContainer) throws Exception {
		MedicineEntity data = medicineRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setUnitEntity(unitService.getUnitListById(dataContainer.getUnitEntity().getId()));
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return medicineRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public MedicineEntity deleteMedicineById(String ID) throws Exception {
		MedicineEntity data = medicineRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return medicineRepository.saveAndFlush(data);	
	}
}
