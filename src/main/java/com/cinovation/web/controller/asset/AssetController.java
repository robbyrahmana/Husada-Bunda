package com.cinovation.web.controller.asset;

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

import com.cinovation.web.dto.asset.AssetDto;
import com.cinovation.web.entity.asset.AssetEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.asset.AssetService;

@RestController
@RequestMapping(value = "/asset/asset")
public class AssetController extends DataConverter {

	@Inject
	AssetService assetService;
	
	public AssetController() {
		server = AssetEntity.class;
		view = AssetDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<AssetDto> getTable(String filter1, String filter2, Pageable pageable) {

		Page<AssetEntity> page = assetService.getAssetTable(filter1, filter2, pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<AssetDto> getList() {
	      
		List<AssetEntity> page = assetService.getAssetList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetDto getListById(@PathVariable("id") String ID) {
		
        AssetEntity page = assetService.getAssetListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetDto save(@Validated @RequestBody AssetDto data) throws Exception {

		AssetEntity page = assetService.saveAsset(serverData(data));
		
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetDto update(@Validated @RequestBody AssetDto data) throws Exception {
		
        AssetEntity page = assetService.updateAsset(serverData(data));
        
        return viewData(page);
    }
}
