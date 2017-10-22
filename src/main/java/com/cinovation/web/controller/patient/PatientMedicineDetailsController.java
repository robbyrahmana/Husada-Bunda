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

import com.cinovation.web.dto.patient.PatientMedicineDetailsDto;
import com.cinovation.web.entity.patient.PatientMedicineDetailsEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.patient.PatientMedicineDetailsService;

@RestController
@RequestMapping(value = "/patient/patientmedicinedetails")
public class PatientMedicineDetailsController extends DataConverter {

	@Inject
	PatientMedicineDetailsService patientMedicineDetailsService;
	
	public PatientMedicineDetailsController() {
		server = PatientMedicineDetailsEntity.class;
		view = PatientMedicineDetailsDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PatientMedicineDetailsDto> getTable(String filter1, Pageable pageable) {
		
        Page<PatientMedicineDetailsEntity> page = patientMedicineDetailsService.getPatientMedicineDetailsTable(filter1, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PatientMedicineDetailsDto> getList() {
		
        List<PatientMedicineDetailsEntity> page = patientMedicineDetailsService.getPatientMedicineDetailsList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDetailsDto getListById(@PathVariable("id") String ID) {
		
        PatientMedicineDetailsEntity page = patientMedicineDetailsService.getPatientMedicineDetailsListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDetailsDto save(@Validated @RequestBody PatientMedicineDetailsDto data) throws Exception {
		
        PatientMedicineDetailsEntity page = patientMedicineDetailsService.savePatientMedicineDetails(serverData(data));

        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PatientMedicineDetailsDto update(@Validated @RequestBody PatientMedicineDetailsDto data) throws Exception {
		
        PatientMedicineDetailsEntity page = patientMedicineDetailsService.updatePatientMedicineDetails(serverData(data));

        return viewData(page);
    }
}
