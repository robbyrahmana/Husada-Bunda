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

import com.cinovation.web.dto.patient.PatientAdministrationDto;
import com.cinovation.web.entity.patient.PatientAdministrationEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientAdministrationService;

@RestController
@RequestMapping(value = "/patient/patientadministration")
public class PatientAdministrationController extends DataConverter {

	@Inject
	PatientAdministrationService patientAdministrationService;

	public PatientAdministrationController() {
		server = PatientAdministrationEntity.class;
		view = PatientAdministrationDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientAdministrationDto> getTable(String filter1, String filter2, String filter3, Pageable pageable) {
		
        Page<PatientAdministrationEntity> page = patientAdministrationService.getPatientAdministrationTable(filter1, filter2, filter3, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getTableActionByDokterId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientAdministrationDto> getTableByDokterId(String filter1, Pageable pageable) {
		
        Page<PatientAdministrationEntity> page = patientAdministrationService.getPatientAdministrationTableByDokterId(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientAdministrationDto> getList() {
		
        List<PatientAdministrationEntity> page = patientAdministrationService.getPatientAdministrationList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientAdministrationDto getListById(@PathVariable("id") String ID) {
		
        PatientAdministrationEntity page = patientAdministrationService.getPatientAdministrationListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientAdministrationDto save(@Validated @RequestBody PatientAdministrationDto data) throws Exception {
        
		PatientAdministrationEntity page = patientAdministrationService.savePatientAdministration(serverData(data));
        
		return viewData(page);
    }
	
	@RequestMapping(value = "/updateStatusById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientAdministrationDto updateById(@PathVariable("id") String ID) throws Exception {
        
		PatientAdministrationEntity page = patientAdministrationService.updateStatusById(ID);
        
		return viewData(page);
    }
}
