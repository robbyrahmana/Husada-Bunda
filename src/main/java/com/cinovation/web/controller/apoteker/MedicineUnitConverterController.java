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

import com.cinovation.web.dto.apoteker.MedicineUnitConverterDto;
import com.cinovation.web.entity.apoteker.MedicineUnitConverterEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.apoteker.MedicineUnitConverterService;

@RestController
@RequestMapping(value = "/apoteker/medicineunitconverter")
public class MedicineUnitConverterController extends DataConverter {

	@Inject
	MedicineUnitConverterService medicineUnitConverterService;
	
	public MedicineUnitConverterController() {
		server = MedicineUnitConverterEntity.class;
		view = MedicineUnitConverterDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<MedicineUnitConverterDto> getTable(String filter1, Pageable pageable) {

		Page<MedicineUnitConverterEntity> page = medicineUnitConverterService.getMedicineUnitConverterTableByMedicineId(filter1, pageable);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<MedicineUnitConverterDto> getList() {

		List<MedicineUnitConverterEntity> page = medicineUnitConverterService.getMedicineUnitConverterList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineUnitConverterDto getListById(@PathVariable("id") String ID) {

		MedicineUnitConverterEntity page = medicineUnitConverterService.getMedicineUnitConverterListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineUnitConverterDto save(@Validated @RequestBody MedicineUnitConverterDto data) throws Exception {

		MedicineUnitConverterEntity page = medicineUnitConverterService.saveMedicineUnitConverter(serverData(data));
        
		return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public MedicineUnitConverterDto update(@Validated @RequestBody MedicineUnitConverterDto data) throws Exception {

		MedicineUnitConverterEntity page = medicineUnitConverterService.updateMedicineUnitConverter(serverData(data));
        
		return viewData(page);
    }
	
	// Additional
	@RequestMapping(value = "/getListByMedicineIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<MedicineUnitConverterDto> getListByMedicineId(@PathVariable("id") String ID) {

		List<MedicineUnitConverterEntity> page = medicineUnitConverterService.getMedicineUnitConverterListByMedicineId(ID);
    	
        return viewDataList(page);
    }
}
