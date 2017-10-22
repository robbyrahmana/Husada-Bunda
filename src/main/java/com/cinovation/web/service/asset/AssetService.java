package com.cinovation.web.service.asset;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.asset.AssetEntity;

public interface AssetService {
	Page<AssetEntity> getAssetTable(String filter1, String filter2, Pageable pageable);
	
	List<AssetEntity> getAssetList();
	
	AssetEntity getAssetListById(String ID);
	
	AssetEntity saveAsset(AssetEntity dataContainer) throws Exception;
	
	AssetEntity updateAsset(AssetEntity dataContainer) throws Exception;
	
	AssetEntity deleteAssetById(String ID) throws Exception;
}
