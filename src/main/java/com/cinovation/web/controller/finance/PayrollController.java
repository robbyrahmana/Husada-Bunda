package com.cinovation.web.controller.finance;

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

import com.cinovation.web.dto.finance.PayrollDto;
import com.cinovation.web.entity.finance.PayrollEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.finance.PayrollService;

@RestController
@RequestMapping(value = "/finance/payroll")
public class PayrollController extends DataConverter {

	@Inject
	PayrollService payrollService;
	
	public PayrollController() {
		server = PayrollEntity.class;
		view = PayrollDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<PayrollDto> getTable(String filter1, String filter2, Pageable pageable) {
		
		Page<PayrollEntity> page = payrollService.getPayrollTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<PayrollDto> getList() {

		List<PayrollEntity> page = payrollService.getPayrollList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PayrollDto getListById(@PathVariable("id") String ID) {
		
        PayrollEntity page = payrollService.getPayrollListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PayrollDto save(@Validated @RequestBody PayrollDto data) throws Exception {
		
        PayrollEntity page = payrollService.savePayroll(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public PayrollDto update(@Validated @RequestBody PayrollDto data) throws Exception {

		PayrollEntity page = payrollService.updatePayroll(serverData(data));
		
        return viewData(page);
    }
}
