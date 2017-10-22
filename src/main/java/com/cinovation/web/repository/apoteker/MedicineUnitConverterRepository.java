package com.cinovation.web.repository.apoteker;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;

public interface MedicineUnitConverterRepository extends JpaRepository<MedicineUnitConverterEntity, String> {
	
	Page<MedicineUnitConverterEntity> findByMedicineEntityId(String ID, Pageable pageable);
	
	MedicineUnitConverterEntity findByMedicineEntityIdAndUnitEntityId(String medicineId, String unitId);
	
	List<MedicineUnitConverterEntity> findByMedicineEntityId(String id);
	
}
