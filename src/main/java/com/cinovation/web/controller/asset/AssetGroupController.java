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

import com.cinovation.web.dto.asset.AssetGroupDto;
import com.cinovation.web.entity.asset.AssetGroupEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.asset.AssetGroupService;

@RestController
@RequestMapping(value = "/asset/assetgroup")
public class AssetGroupController extends DataConverter {

	@Inject
	AssetGroupService assetGroupService;
	
	public AssetGroupController() {
		server = AssetGroupEntity.class;
		view = AssetGroupDto.class;
	}
	
	@RequestMapping(value = "/getTableAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Page<AssetGroupDto> getTable(Pageable pageable) {
		
		Page<AssetGroupEntity> page = assetGroupService.getAssetGroupTable(pageable);
    	
    	return viewDataPage(page);
    }
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<AssetGroupDto> getList() {

		List<AssetGroupEntity> page = assetGroupService.getAssetGroupList();
    	
    	return viewDataList(page);
    }
	
	@RequestMapping(value = "/getListByIdAction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetGroupDto getListById(@PathVariable("id") String ID) {
		
        AssetGroupEntity page = assetGroupService.getAssetGroupListById(ID);
    	
    	return viewData(page);
    }
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetGroupDto save(@Validated @RequestBody AssetGroupDto data) throws Exception {
		
        AssetGroupEntity page = assetGroupService.saveAssetGroup(serverData(data));
        
        return viewData(page);
    }
	
	@RequestMapping(value = "/updateAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public AssetGroupDto update(@Validated @RequestBody AssetGroupDto data) throws Exception {

		AssetGroupEntity page = assetGroupService.updateAssetGroup(serverData(data));
		
        return viewData(page);
    }
}
