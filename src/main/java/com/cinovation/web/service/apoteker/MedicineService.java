package com.cinovation.web.service.apoteker;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.apoteker.MedicineEntity;

public interface MedicineService {

	Page<MedicineEntity> getMedicineTable(String filter1, String filter2, Pageable pageable);
	
	List<MedicineEntity> getMedicineList();
	
	MedicineEntity getMedicineListById(String ID);
	
	MedicineEntity saveMedicine(MedicineEntity dataContainer) throws Exception;
	
	MedicineEntity updateMedicine(MedicineEntity dataContainer) throws Exception;
	
	MedicineEntity deleteMedicineById(String ID) throws Exception;
}
