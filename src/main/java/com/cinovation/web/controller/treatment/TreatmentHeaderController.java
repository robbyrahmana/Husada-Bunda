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

import com.cinovation.web.dto.treatment.TreatmentHeaderDto;
import com.cinovation.web.entity.treatment.TreatmentHeaderEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.treatment.TreatmentHeaderService;

@RestController
@RequestMapping(value = "/treatment/treatmentheader")
public class TreatmentHeaderController extends DataConverter {

	@Inject
	TreatmentHeaderService treatmentHeaderService;

	public TreatmentHeaderController() {
		server = TreatmentHeaderEntity.class;
		view = TreatmentHeaderDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<TreatmentHeaderDto> getTable(String filter1, String filter2, Pageable pageable) {
		
        Page<TreatmentHeaderEntity> page = treatmentHeaderService.getTreatmentHeaderTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<TreatmentHeaderDto> getList() {
		
        List<TreatmentHeaderEntity> page = treatmentHeaderService.getTreatmentHeaderList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TreatmentHeaderDto getListById(@PathVariable("id") String ID) {
		
        TreatmentHeaderEntity page = treatmentHeaderService.getTreatmentHeaderListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TreatmentHeaderDto save(@Validated @RequestBody TreatmentHeaderDto data) throws Exception {
		
        TreatmentHeaderEntity page = treatmentHeaderService.saveTreatmentHeader(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public TreatmentHeaderDto update(@Validated @RequestBody TreatmentHeaderDto data) throws Exception {
		
        TreatmentHeaderEntity page = treatmentHeaderService.updateTreatmentHeader(serverData(data));
        
        return viewData(page);
    }
}
