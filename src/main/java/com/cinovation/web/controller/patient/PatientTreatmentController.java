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

import com.cinovation.web.dto.patient.PatientTreatmentDto;
import com.cinovation.web.entity.patient.PatientTreatmentEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientTreatmentService;

@RestController
@RequestMapping(value = "/patient/patienttreatment")
public class PatientTreatmentController extends DataConverter {

	@Inject
	PatientTreatmentService patientTreatmentService;
	
	public PatientTreatmentController() {
		server = PatientTreatmentEntity.class;
		view = PatientTreatmentDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientTreatmentDto> getTable(String filter1, String filter2, String filter3, Pageable pageable) {
        
		Page<PatientTreatmentEntity> page = patientTreatmentService.getPatientTreatmentTable(filter1, filter2, filter3, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getTableActionByDokterId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientTreatmentDto> getTableByDokterId(String filter1, Pageable pageable) {
        
		Page<PatientTreatmentEntity> page = patientTreatmentService.getPatientTreatmentTableByDokterId(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientTreatmentDto> getList() {
        
		List<PatientTreatmentEntity> page = patientTreatmentService.getPatientTreatmentList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientTreatmentDto getListById(@PathVariable("id") String ID) {
        
		PatientTreatmentEntity page = patientTreatmentService.getPatientTreatmentListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientTreatmentDto save(@Validated @RequestBody PatientTreatmentDto data) throws Exception {
        
		PatientTreatmentEntity page = patientTreatmentService.savePatientTreatment(serverData(data));
        
		return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientTreatmentDto update(@Validated @RequestBody PatientTreatmentDto data) throws Exception{
        
		PatientTreatmentEntity page = patientTreatmentService.updatePatientTreatment(serverData(data));
        
		return viewData(page);
    }
}
