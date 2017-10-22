package com.cinovation.web.repository.asset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.asset.AssetEntity;

public interface AssetRepository extends JpaRepository<AssetEntity, String> {
	
	Page<AssetEntity> findByCdContainingAndNameContainingOrderByNameAsc(String filter1, String filter2, Pageable pageable);
	
	AssetEntity findByCdOrName(String cd, String name);
}
