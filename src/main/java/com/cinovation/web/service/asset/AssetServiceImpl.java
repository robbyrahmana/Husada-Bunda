package com.cinovation.web.service.asset;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.asset.AssetEntity;
import com.cinovation.web.repository.asset.AssetGroupRepository;
import com.cinovation.web.repository.asset.AssetRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class AssetServiceImpl implements AssetService{
	private static final Logger logger = Logger.getLogger(AssetServiceImpl.class);
	
	@Autowired
	AssetRepository assetRepository;
	
	@Inject
	AssetGroupService assetGroupService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<AssetEntity> getAssetTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return assetRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<AssetEntity> getAssetList() {
		return assetRepository.findAll();
	}
	
	@Override
	public AssetEntity getAssetListById(String ID) {
		return assetRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public AssetEntity saveAsset(AssetEntity dataContainer) throws Exception {
		AssetEntity duplicate = assetRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return assetRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public AssetEntity updateAsset(AssetEntity dataContainer) throws Exception {
		AssetEntity data = assetRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setAssetGroupEntity(assetGroupService.getAssetGroupListById(dataContainer.getAssetGroupEntity().getId()));
		data.setPrice(dataContainer.getPrice());
		data.setGetDate(dataContainer.getGetDate());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return assetRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public AssetEntity deleteAssetById(String ID) throws Exception {
		AssetEntity data = assetRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return assetRepository.saveAndFlush(data);	
	}
}
