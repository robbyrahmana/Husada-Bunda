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

import com.cinovation.web.dto.patient.PatientOperationDto;
import com.cinovation.web.entity.patient.PatientOperationEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientOperationService;

@RestController
@RequestMapping(value = "/patient/patientoperation")
public class PatientOperationController extends DataConverter {

	@Inject
	PatientOperationService patientOperationService;
	
	public PatientOperationController() {
		server = PatientOperationEntity.class;
		view = PatientOperationDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientOperationDto> getTable(String filter1, String filter2, String filter3, Pageable pageable) {
		
        Page<PatientOperationEntity> page = patientOperationService.getPatientOperationTable(filter1, filter2, filter3, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientOperationDto> getList() {
        
		List<PatientOperationEntity> page = patientOperationService.getPatientOperationList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientOperationDto getListById(@PathVariable("id") String ID) {
        
		PatientOperationEntity page = patientOperationService.getPatientOperationListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientOperationDto save(@Validated @RequestBody PatientOperationDto data) throws Exception {
        
		PatientOperationEntity page = patientOperationService.savePatientOperation(serverData(data));
        
		return viewData(page);
    }
}
