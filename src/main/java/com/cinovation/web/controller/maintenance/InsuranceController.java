package com.cinovation.web.controller.maintenance;

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

import com.cinovation.web.dto.maintenance.InsuranceDto;
import com.cinovation.web.entity.maintenance.InsuranceEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.maintenance.InsuranceService;

@RestController
@RequestMapping(value = "/maintenance/insurance")
public class InsuranceController extends DataConverter {

	@Inject
	InsuranceService insuranceService;
	
	public InsuranceController() {
		server = InsuranceEntity.class;
		view = InsuranceDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<InsuranceDto> getTable(String filter1, Pageable pageable) {
		
        Page<InsuranceEntity> page = insuranceService.getInsuranceTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<InsuranceDto> getList() {
		
        List<InsuranceEntity> page = insuranceService.getInsuranceList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public InsuranceDto getListById(@PathVariable("id") String ID) {
		
        InsuranceEntity page = insuranceService.getInsuranceListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public InsuranceDto save(@Validated @RequestBody InsuranceDto data) throws Exception {
		
        InsuranceEntity page = insuranceService.saveInsurance(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public InsuranceDto update(@Validated @RequestBody InsuranceDto data) throws Exception {
		
        InsuranceEntity page = insuranceService.updateInsurance(serverData(data));
        
        return viewData(page);
    }
}
