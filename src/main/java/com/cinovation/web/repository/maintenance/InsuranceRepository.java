package com.cinovation.web.repository.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.maintenance.InsuranceEntity;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, String> {
	
	Page<InsuranceEntity> findByOrderByInsuranceAsc(Pageable pageable);
	
	InsuranceEntity findByInsurance(String title);

}
