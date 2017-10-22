package com.cinovation.web.controller.patient;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.patient.PatientMedicineDto;
import com.cinovation.web.entity.patient.PatientMedicineEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientMedicineService;

@RestController
@RequestMapping(value = "/patient/patientmedicine")
public class PatientMedicineCrontroller extends DataConverter {

	@Inject
	PatientMedicineService patientMedicineService;
	
	public PatientMedicineCrontroller() {
		server = PatientMedicineEntity.class;
		view = PatientMedicineDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientMedicineDto> getTable(String filter1,String filter2, String filter3, String filter4, Pageable pageable) {
		
        Page<PatientMedicineEntity> page = patientMedicineService.getPatientMedicineTable(filter1, filter2, filter3, filter4, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getTableActionByStatusId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientMedicineDto> getTableByStatusId(String filter1, String filter2, Pageable pageable) {
		
        Page<PatientMedicineEntity> page = patientMedicineService.getPatientMedicineTableByStatusId(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientMedicineDto> getList() {
		
        List<PatientMedicineEntity> page = patientMedicineService.getPatientMedicineList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDto getListById(@PathVariable("id") String ID) {
		
        PatientMedicineEntity page = patientMedicineService.getPatientMedicineListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDto save(@Validated @RequestBody PatientMedicineDto data) throws Exception {
		
        PatientMedicineEntity page = patientMedicineService.savePatientMedicine(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateStatusById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDto updateById(@PathVariable("id") String ID) throws Exception {
		
        PatientMedicineEntity page = patientMedicineService.updateStatusById(ID);
        
        return viewData(page);
    }
}
