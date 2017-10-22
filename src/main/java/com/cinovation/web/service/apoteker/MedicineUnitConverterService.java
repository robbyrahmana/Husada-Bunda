package com.cinovation.web.service.apoteker;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;

public interface MedicineUnitConverterService {

	Page<MedicineUnitConverterEntity> getMedicineUnitConverterTableByMedicineId(String id, Pageable pageable);
	
	List<MedicineUnitConverterEntity> getMedicineUnitConverterList();
	
	MedicineUnitConverterEntity getMedicineUnitConverterListById(String ID);
	
	MedicineUnitConverterEntity saveMedicineUnitConverter(MedicineUnitConverterEntity dataContainer) throws Exception;
	
	MedicineUnitConverterEntity updateMedicineUnitConverter(MedicineUnitConverterEntity dataContainer) throws Exception;
	
	MedicineUnitConverterEntity deleteMedicineUnitConverterById(String ID) throws Exception;
	
	List<MedicineUnitConverterEntity> getMedicineUnitConverterListByMedicineId(String ID);
}
