package com.cinovation.web.service;

import com.cinovation.web.entity.UserEntity;
import com.cinovation.web.entity.UserUserRoleEntity;

/*
 * RSSYSE-1
 * Start Fix : TIDAK BISA LOGIN
 * Description : create service untuk useruserrole dengan method insert dengan asumsi ini hanya dipanggil saat pertama create
 * ADD:
 */
public interface UserUserRoleService {

	UserUserRoleEntity saveUserRole(UserEntity dataContainer) throws Exception;

}
/*
 * End Fix
 */