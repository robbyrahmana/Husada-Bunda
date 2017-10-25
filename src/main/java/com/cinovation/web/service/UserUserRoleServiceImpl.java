package com.cinovation.web.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.constant.ApplicationConstants;
import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.entity.UserUserRoleEntity;
import com.cinovation.web.repository.UserRoleRepository;
import com.cinovation.web.repository.UserUserRoleRepository;

/*
 * RSSYSE-1
 * Start Fix : TIDAK BISA LOGIN
 * Description : create service implementation untuk useruserrole dengan method insert dengan asumsi ini hanya dipanggil saat pertama create
 * ADD:
 */
@Service
@RepositoryEventHandler
public class UserUserRoleServiceImpl implements UserUserRoleService{

	@Autowired
	UserUserRoleRepository userUserRoleRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	HelperService helperService;
	
	@Override
	public UserUserRoleEntity saveUserRole(UserEntity userEntity) throws Exception {
		UserUserRoleEntity UserUserRoleEntity = userUserRoleRepository.findByUserEntityId(userEntity.getId());
		
		if (UserUserRoleEntity == null) {
			UserUserRoleEntity = new UserUserRoleEntity();
		}
		
		UserUserRoleEntity.setIsDel(0);
		UserUserRoleEntity.setUserEntity(userEntity);
		UserUserRoleEntity.setCreateDate(helperService.setDateFormat(new Date()));
		UserUserRoleEntity.setUserRoleEntity(userRoleRepository.findOne(ApplicationConstants.ROLE_APP));
		
		return userUserRoleRepository.saveAndFlush(UserUserRoleEntity);
		
	}
}
/*
 * End Fix
 */
