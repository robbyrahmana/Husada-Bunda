package com.cinovation.web.service.functionality;

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

import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.entity.functionality.FunctionalityEntity;
import com.cinovation.web.repository.functionality.FunctionalityRepository;
import com.cinovation.web.repository.functionality.PositionRepository;
import com.cinovation.web.repository.functionality.SMFRepository;
import com.cinovation.web.repository.maintenance.GenderRepository;
import com.cinovation.web.repository.maintenance.ReligionRepository;
import com.cinovation.web.service.HelperService;
import com.cinovation.web.service.UserService;
import com.cinovation.web.service.maintenance.GenderService;
import com.cinovation.web.service.maintenance.ReligionService;
import com.cinovation.web.validator.exception.DuplicateEntryException;
import com.cinovation.web.validator.exception.RecordNotFoundException;

@Service
@RepositoryEventHandler
public class FunctionalityServiceImpl implements FunctionalityService{
	private static final Logger logger = Logger.getLogger(FunctionalityServiceImpl.class);
	
	@Autowired
	FunctionalityRepository functionalityRepository;
	
	@Inject
	PositionService positionService;
	
	@Inject
	SMFService sMFService;
	
	@Inject
	GenderService genderService;
	
	@Inject
	ReligionService religionService;
	
	@Inject
	UserService userService;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public Page<FunctionalityEntity> getFunctionalityTable(String filter1, String filter2, Pageable pageable) {
		logger.info("");
		return functionalityRepository.findByCdContainingAndNameContainingOrderByNameAsc(filter1, filter2, pageable);
	}
	
	@Override
	public List<FunctionalityEntity> getFunctionalityList() {
		return functionalityRepository.findAll();
	}
	
	@Override
	public FunctionalityEntity getFunctionalityListById(String ID) {
		return functionalityRepository.findOne(ID);
	}
	
	@Override
	public FunctionalityEntity getFunctionalityListByCd(String cd) {
		return functionalityRepository.findByCd(cd);
	}
	
	@HandleBeforeCreate
	@Override
	@Transactional(rollbackFor=DuplicateEntryException.class)
	public FunctionalityEntity saveFunctionality(FunctionalityEntity dataContainer) throws Exception {
		FunctionalityEntity duplicate = functionalityRepository.findByCdOrName(dataContainer.getCd(), dataContainer.getName());
		
		if (duplicate != null) {
			throw new DuplicateEntryException();
		}
		
		dataContainer.setCreateDate(helperService.setDateFormat(new Date()));
		
		//save record for security
		UserEntity user = new UserEntity();
		user.setCreateDate(helperService.setDateFormat(new Date()));
		user.setUsername(dataContainer.getCd());
		userService.saveUser(user);
		
		return functionalityRepository.saveAndFlush(dataContainer);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public FunctionalityEntity updateFunctionality(FunctionalityEntity dataContainer) throws Exception {
		FunctionalityEntity data = functionalityRepository.findOne(dataContainer.getId());
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		String oldCd = data.getCd();
		String newCd = dataContainer.getCd();

		data.setPositionEntity(positionService.getPositionListById(dataContainer.getPositionEntity().getId()));
		data.setsMFEntity(sMFService.getSMFListById(dataContainer.getsMFEntity().getId()));
		data.setCd(dataContainer.getCd());
		data.setName(dataContainer.getName());
		data.setGenderEntity(genderService.getGenderListById(dataContainer.getGenderEntity().getId()));
		data.setBirthplace(dataContainer.getBirthplace());
		data.setBirthday(dataContainer.getBirthday());
		if (dataContainer.getReligionEntity() != null) data.setReligionEntity(religionService.getReligionListById(dataContainer.getReligionEntity().getId()));
		data.setAddrline1(dataContainer.getAddrline1());
		data.setAddrline2(dataContainer.getAddrline2());
		data.setAddrline3(dataContainer.getAddrline3());
		data.setAddrline4(dataContainer.getAddrline4());
		data.setAddrline5(dataContainer.getAddrline5());
		data.setPostcode(dataContainer.getPostcode());
		data.setMobilenumber(dataContainer.getMobilenumber());
		data.setSalary(dataContainer.getSalary());
		data.setInDate(dataContainer.getInDate());
		
		data.setUpdateDate(helperService.setDateFormat(new Date()));
		
		//update record for security
		UserEntity user = userService.getUserListByCd(oldCd);
		user.setUsername(newCd);
		userService.updateUser(user);
		
		return functionalityRepository.saveAndFlush(data);		
	}
	
	@Override
	public List<FunctionalityEntity> getPositionEntityId(String ID) {
		return functionalityRepository.findByPositionEntityId(ID);
	}
	
	@HandleBeforeSave
	@Override
	@Transactional(rollbackFor=RecordNotFoundException.class)
	public FunctionalityEntity deleteFunctionalityById(String ID) throws Exception {
		FunctionalityEntity data = functionalityRepository.findOne(ID);
		
		if (data == null) {
			throw new RecordNotFoundException();
		}
		
		return functionalityRepository.saveAndFlush(data);	
	}
}
