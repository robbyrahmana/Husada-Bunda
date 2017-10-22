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

import com.cinovation.web.dto.patient.PatientOperationDetailsDto;
import com.cinovation.web.entity.patient.PatientOperationDetailsEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientOperationDetailsService;

@RestController
@RequestMapping(value = "/patient/patientoperationdetails")
public class PatientOperationDetailsController extends DataConverter {

	@Inject
	PatientOperationDetailsService patientOperationDetailsService;
	
	public PatientOperationDetailsController() {
		server = PatientOperationDetailsEntity.class;
		view = PatientOperationDetailsDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientOperationDetailsDto> getTable(String filter1, Pageable pageable) {
        
		Page<PatientOperationDetailsEntity> page = patientOperationDetailsService.getPatientOperationDetailsTable(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getTableActionByDokterId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientOperationDetailsDto> getTableByDokterId(String filter1, Pageable pageable) {
        
		Page<PatientOperationDetailsEntity> page = patientOperationDetailsService.getPatientOperationDetailsTableByDokterId(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientOperationDetailsDto> getList() {
        
		List<PatientOperationDetailsEntity> page = patientOperationDetailsService.getPatientOperationDetailsList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientOperationDetailsDto getListById(@PathVariable("id") String ID) {
        
		PatientOperationDetailsEntity page = patientOperationDetailsService.getPatientOperationDetailsListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientOperationDetailsDto save(@Validated @RequestBody PatientOperationDetailsDto data) throws Exception {
        
		PatientOperationDetailsEntity page = patientOperationDetailsService.savePatientOperationDetails(serverData(data));

        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientOperationDetailsDto update(@Validated @RequestBody PatientOperationDetailsDto data) throws Exception {
        
		PatientOperationDetailsEntity page = patientOperationDetailsService.updatePatientOperationDetails(serverData(data));

        return viewData(page);
    }
}
