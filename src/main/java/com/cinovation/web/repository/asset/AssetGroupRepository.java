package com.cinovation.web.repository.asset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.asset.AssetGroupEntity;

public interface AssetGroupRepository extends JpaRepository<AssetGroupEntity, String> {
	
	Page<AssetGroupEntity> findByOrderByNameAsc(Pageable pageable);
	
	AssetGroupEntity findByCdOrName(String cd, String name);
}
