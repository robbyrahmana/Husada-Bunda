package com.cinovation.web.service.asset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.asset.AssetGroupEntity;

public interface AssetGroupService {
	Page<AssetGroupEntity> getAssetGroupTable(Pageable pageable);
	
	List<AssetGroupEntity> getAssetGroupList();
	
	AssetGroupEntity getAssetGroupListById(String ID);
	
	AssetGroupEntity saveAssetGroup(AssetGroupEntity dataContainer) throws Exception;
	
	AssetGroupEntity updateAssetGroup(AssetGroupEntity dataContainer) throws Exception;
	
	AssetGroupEntity deleteAssetGroupById(String ID) throws Exception;
}
