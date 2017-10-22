package com.cinovation.web.controller.apoteker;

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

import com.cinovation.web.dto.apoteker.MedicineDto;
import com.cinovation.web.entity.apoteker.MedicineEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.apoteker.MedicineService;

@RestController
@RequestMapping(value = "/apoteker/medicine")
public class MedicineController extends DataConverter {

	@Inject
	MedicineService medicineService;
	
	public MedicineController() {
		server = MedicineEntity.class;
		view = MedicineDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<MedicineDto> getTable(String filter1, String filter2, Pageable pageable) {

		Page<MedicineEntity> page = medicineService.getMedicineTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<MedicineDto> getList() {

    	List<MedicineEntity> page = medicineService.getMedicineList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineDto getListById(@PathVariable("id") String ID) {

        MedicineEntity page = medicineService.getMedicineListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineDto save(@Validated @RequestBody MedicineDto data) throws Exception {
        
        MedicineEntity page = medicineService.saveMedicine(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineDto update(@Validated @RequestBody MedicineDto data) throws Exception {
        
        MedicineEntity page = medicineService.updateMedicine(serverData(data));
        
        return viewData(page);
    }
}
