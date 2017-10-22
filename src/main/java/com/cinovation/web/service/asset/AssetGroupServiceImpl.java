package com.cinovation.web.service.asset;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinovation.web.entity.asset.AssetGroupEntity;
import com.cinovation.web.repository.asset.AssetGroupRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class AssetGroupServiceImpl implements AssetGroupService{
	private static final Logger logger = Logger.getLogger(AssetGroupServiceImpl.class);
	
	@Autowired
	AssetGroupRepository assetGroupRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<AssetGroupEntity> getAssetGroupTable(Pageable pageable) {
		return assetGroupRepository.findByOrderByNameAsc(pageable);
	}
	
	@Override
	public List<AssetGroupEntity> getAssetGroupList() {
		return assetGroupRepository.findAll();
	}
	
	@Override
	public AssetGroupEntity getAssetGroupListById(String ID) {
		return assetGroupRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public AssetGroupEntity saveAssetGroup(AssetGroupEntity dataContainer) throws Exception {
		AssetGroupEntity duplicate = assetGroupRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return assetGroupRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public AssetGroupEntity updateAssetGroup(AssetGroupEntity dataContainer) throws Exception {
		AssetGroupEntity data = assetGroupRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}

		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setRemark(dataContainer.getRemark());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return assetGroupRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public AssetGroupEntity deleteAssetGroupById(String ID) throws Exception {
		AssetGroupEntity data = assetGroupRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return assetGroupRepository.saveAndFlush(data);	
	}
}
