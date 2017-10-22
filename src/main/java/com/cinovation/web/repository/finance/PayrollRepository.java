package com.cinovation.web.repository.finance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.finance.PayrollEntity;

public interface PayrollRepository extends JpaRepository<PayrollEntity, String> {
	
	Page<PayrollEntity> findByForMonthAndForYearOrderByFunctionalityEntityNameAsc(String filter1, String filter2, Pageable pageable);
	
}