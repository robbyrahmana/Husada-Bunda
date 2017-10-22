package com.cinovation.web.controller.treatment;

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

import com.cinovation.web.constant.ApplicationConstants;
import com.cinovation.web.dto.treatment.TreatmentBodyDto;
import com.cinovation.web.entity.treatment.TreatmentBodyEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.treatment.TreatmentBodyService;

@RestController
@RequestMapping(value = "/treatment/treatmentbody")
public class TreatmentBodyController extends DataConverter {

	@Inject
	TreatmentBodyService treatmentBodyService;

	public TreatmentBodyController() {
		server = TreatmentBodyEntity.class;
		view = TreatmentBodyDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<TreatmentBodyDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentBodyDto> getList() {
		
        List<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TreatmentBodyDto getListById(@PathVariable("id") String ID) {
		
        TreatmentBodyEntity page = treatmentBodyService.getTreatmentBodyListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
    public TreatmentBodyDto save(@Validated @RequestBody TreatmentBodyDto data) throws Exception {
		
        TreatmentBodyEntity page = treatmentBodyService.saveTreatmentBody(serverData(data));
        
        return viewData(page);
        
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TreatmentBodyDto update(@Validated @RequestBody TreatmentBodyDto data) throws Exception {
		
        TreatmentBodyEntity page = treatmentBodyService.updateTreatmentBody(serverData(data));
        
        return viewData(page);
    }
	
	// Additional
	@RequestMapping(value = "/getListByHeaderIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentBodyDto> getListByCategoryId(@PathVariable("id") String ID) {
		
        List<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyListByHeaderId(ID);
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListForNurseTreatment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentBodyDto> getListForNurseTreatment() {
		
        List<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyListByProductId(ApplicationConstants.PRODUCT_TINDAKAN);
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListForNurseMedicine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentBodyDto> getListForNurseMedicine() {
		
        List<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyListByProductId(ApplicationConstants.PRODUCT_OBAT);
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListForNurseOperation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentBodyDto> getListForNurseOperation() {
		
        List<TreatmentBodyEntity> page = treatmentBodyService.getTreatmentBodyListByProductId(ApplicationConstants.PRODUCT_OPERASI);
    	
    	return viewDataList(page);
    }
}
