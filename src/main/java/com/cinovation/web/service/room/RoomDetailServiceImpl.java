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

import com.cinovation.web.entity.room.RoomDetailEntity;
import com.cinovation.web.repository.room.RoomCategoryRepository;
import com.cinovation.web.repository.room.RoomDetailRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class RoomDetailServiceImpl implements RoomDetailService{
	
	private static final Logger logger = Logger.getLogger(RoomCategoryServiceImpl.class);
	
	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	@Autowired
	RoomCategoryService roomCategoryService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<RoomDetailEntity> getRoomDetailTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return roomDetailRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	@Transactional
	public List<RoomDetailEntity> getRoomDetailList() {
		return roomDetailRepository.findAll();
	}
	
	@Override
	@Transactional
	public RoomDetailEntity getRoomDetailListById(String ID) {
		return roomDetailRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public RoomDetailEntity saveRoomDetail(RoomDetailEntity dataContainer) throws Exception {
		RoomDetailEntity duplicate = roomDetailRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return roomDetailRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomDetailEntity updateRoomDetail(RoomDetailEntity dataContainer) throws Exception {
		RoomDetailEntity data = roomDetailRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setCost(dataContainer.getCost());
		data.setDscp(dataContainer.getDscp());
		data.setRoomCategoryEntity(roomCategoryService.getRoomCategoryListById(dataContainer.getRoomCategoryEntity().getId()));
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return roomDetailRepository.saveAndFlush(data);	
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomDetailEntity deleteRoomDetailById(String ID) throws Exception {
		RoomDetailEntity data = roomDetailRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return roomDetailRepository.saveAndFlush(data);	
	}
	
	@Override
	public List<RoomDetailEntity> getRoomDetailListByCategoryId(String ID) {
		return roomDetailRepository.findByRoomCategoryEntityIdContaining(ID);
	}
	
}
