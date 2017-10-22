package com.cinovation.web.service.room;

import java.text.ParseException;
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

import com.cinovation.web.entity.room.RoomCategoryEntity;
import com.cinovation.web.repository.room.RoomCategoryRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class RoomCategoryServiceImpl implements RoomCategoryService {

	private static final Logger logger = Logger.getLogger(RoomCategoryServiceImpl.class);

	@Autowired
	RoomCategoryRepository roomCategoryRepository;

	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<RoomCategoryEntity> getRoomCategoryTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return roomCategoryRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	@Transactional
	public List<RoomCategoryEntity> getRoomCategoryList() {
		return roomCategoryRepository.findAll();
	}
	
	@Override
	@Transactional
	public RoomCategoryEntity getRoomCategoryListById(String ID) {
		return roomCategoryRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public RoomCategoryEntity saveRoomCategory(RoomCategoryEntity dataContainer) throws Exception {
		RoomCategoryEntity duplicate = roomCategoryRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return roomCategoryRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomCategoryEntity updateRoomCategory(RoomCategoryEntity dataContainer) throws Exception {
		RoomCategoryEntity data = roomCategoryRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setDscp(dataContainer.getDscp());
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return roomCategoryRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomCategoryEntity deleteRoomCategoryById(String ID) throws Exception {
		RoomCategoryEntity data = roomCategoryRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return roomCategoryRepository.saveAndFlush(data);	
	}
	
}
