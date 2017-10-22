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

import com.cinovation.web.dto.patient.PatientDto;
import com.cinovation.web.entity.patient.PatientEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientService;

@RestController
@RequestMapping(value = "/patient/patient")
public class PatientController extends DataConverter {

	@Inject
	PatientService patientService;

	public PatientController() {
		server = PatientEntity.class;
		view = PatientDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientDto> getTable(String filter1,String filter2, Pageable pageable) {
		
        Page<PatientEntity> page = patientService.getPatientTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientDto> getList() {
		
        List<PatientEntity> page = patientService.getPatientList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientDto getListById(@PathVariable("id") String ID) {
		
        PatientEntity page = patientService.getPatientListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientDto save(@Validated @RequestBody PatientDto data) throws Exception {
		
        PatientEntity page = patientService.savePatient(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientDto update(@Validated @RequestBody PatientDto data) throws Exception {
		
        PatientEntity page = patientService.updatePatient(serverData(data));
        
        return viewData(page);
    }
}
