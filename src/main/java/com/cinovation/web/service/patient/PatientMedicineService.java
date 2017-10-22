package com.cinovation.web.service.patient;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.patient.PatientMedicineEntity;

public interface PatientMedicineService {

	Page<PatientMedicineEntity> getPatientMedicineTable(String filter1, String filter2, String filter3, String filter4, Pageable pageable);
	
	List<PatientMedicineEntity> getPatientMedicineList();
	
	PatientMedicineEntity getPatientMedicineListById(String ID);
	
	PatientMedicineEntity savePatientMedicine(PatientMedicineEntity dataContainer) throws Exception;
	
	void updatePatientMedicineTotalSumGroupByMedicine(String ID, String old_data, String new_data) throws Exception;
	
	PatientMedicineEntity deletePatientMedicineById(String ID) throws Exception;

	Page<PatientMedicineEntity> getPatientMedicineTableByStatusId(String filter1, String filter2, Pageable pageable);

	PatientMedicineEntity updateStatusById(String id) throws Exception;
}
