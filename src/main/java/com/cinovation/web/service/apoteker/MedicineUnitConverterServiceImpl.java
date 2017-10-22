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

import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;
import com.cinovation.web.repository.apoteker.MedicineUnitConverterRepository;
import com.cinovation.web.repository.maintenance.UnitRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.maintenance.UnitService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class MedicineUnitConverterServiceImpl implements MedicineUnitConverterService{

	private static final Logger logger = Logger.getLogger(MedicineUnitConverterServiceImpl.class);
	
	@Autowired
	MedicineUnitConverterRepository medicineUnitConverterRepository;
	
	@Inject
	UnitService unitService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<MedicineUnitConverterEntity> getMedicineUnitConverterTableByMedicineId(String id, Pageable pageable) {
		logger.info("");
		return medicineUnitConverterRepository.findByMedicineEntityId(id, pageable);
	}
	
	@Override
	public List<MedicineUnitConverterEntity> getMedicineUnitConverterList() {
		return medicineUnitConverterRepository.findAll();
	}
	
	@Override
	public MedicineUnitConverterEntity getMedicineUnitConverterListById(String ID) {
		return medicineUnitConverterRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public MedicineUnitConverterEntity saveMedicineUnitConverter(MedicineUnitConverterEntity dataContainer) throws Exception {
		MedicineUnitConverterEntity duplicate = medicineUnitConverterRepository.findByMedicineEntityIdAndUnitEntityId(dataContainer.getMedicineEntity().getId(), dataContainer.getUnitEntity().getId());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return medicineUnitConverterRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public MedicineUnitConverterEntity updateMedicineUnitConverter(MedicineUnitConverterEntity dataContainer) throws Exception {
		MedicineUnitConverterEntity data = medicineUnitConverterRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setPrice(dataContainer.getPrice());
		data.setQuantity(dataContainer.getQuantity());
		data.setUnitEntity(unitService.getUnitListById(dataContainer.getUnitEntity().getId()));
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return medicineUnitConverterRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public MedicineUnitConverterEntity deleteMedicineUnitConverterById(String ID) throws Exception {
		MedicineUnitConverterEntity data = medicineUnitConverterRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return medicineUnitConverterRepository.saveAndFlush(data);	
	}
	
	@Override
	public List<MedicineUnitConverterEntity> getMedicineUnitConverterListByMedicineId(String ID) {
		return medicineUnitConverterRepository.findByMedicineEntityId(ID);
	}

}
