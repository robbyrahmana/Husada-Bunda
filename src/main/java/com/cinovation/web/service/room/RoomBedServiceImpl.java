package com.cinovation.web.service.room;

import java.text.ParseException;
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

import com.cinovation.web.constant.ApplicationConstants;
import com.cinovation.web.entity.room.RoomBedEntity;
import com.cinovation.web.repository.room.RoomBedRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;
import com.cinovation.web.vo.CountVO;

@Service
@RepositoryEventHandler
public class RoomBedServiceImpl implements RoomBedService{
	
	private static final Logger logger = Logger.getLogger(RoomBedServiceImpl.class);
	
	@Autowired
	RoomBedRepository roomBedRepository;
	
	@Inject
	RoomDetailService roomDetailService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	@Transactional
	public Page<RoomBedEntity> getRoomBedTable(String filter1, Pageable pageable) {
		logger.info("");
		return roomBedRepository.findByCdContainingOrderByCdAsc(filter1, pageable);
	}
	
	@Override
	@Transactional
	public List<RoomBedEntity> getRoomBedList() {
		return roomBedRepository.findAll();
	}
	
	@Override
	@Transactional
	public RoomBedEntity getRoomBedListById(String ID) {
		return roomBedRepository.findOne(ID);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public RoomBedEntity saveRoomBed(RoomBedEntity dataContainer) throws Exception {
		RoomBedEntity duplicate = roomBedRepository.findByCd(dataContainer.getCd());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setIsAvailable(1);
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		return roomBedRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomBedEntity updateRoomBed(RoomBedEntity dataContainer) throws Exception {
		RoomBedEntity data = roomBedRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		data.setCd(dataContainer.getCd());
		data.setDscp(dataContainer.getDscp());
		data.setRoomDetailEntity(roomDetailService.getRoomDetailListById(dataContainer.getRoomDetailEntity().getId()));
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		return roomBedRepository.saveAndFlush(data);		
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public RoomBedEntity deleteRoomBedById(String ID) throws Exception {
		RoomBedEntity data = roomBedRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return roomBedRepository.saveAndFlush(data);	
	}
	
	@Override
	public List<RoomBedEntity> getRoomBedListByDetailId(String ID) {
		return roomBedRepository.findByRoomDetailEntityIdAndIsAvailable(ID, ApplicationConstants.ROOM_STATUS_AVAILABLE);
	}
	
	@Override
	public void updateRoomBedAvailableById(String ID) {
		RoomBedEntity data = roomBedRepository.findOne(ID);
		
		data.setIsAvailable(ApplicationConstants.ROOM_STATUS_USED);
		
		roomBedRepository.saveAndFlush(data);
	}
	
	@Override
	public List<CountVO> findCountRoomByGroupByDetailId() {
		return roomBedRepository.findCountRoomByGroupByDetailId();
	}
}
