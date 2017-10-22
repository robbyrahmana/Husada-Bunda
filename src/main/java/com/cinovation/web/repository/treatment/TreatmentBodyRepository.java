package com.cinovation.web.repository.treatment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinovation.web.entity.treatment.TreatmentBodyEntity;

public interface TreatmentBodyRepository extends JpaRepository<TreatmentBodyEntity, String> {
	
	Page<TreatmentBodyEntity> findByCdContainingAndNameContainingOrderByTreatmentHeaderEntityCdAscCdAsc(String filter1, String filter2, Pageable pageable);
	
	TreatmentBodyEntity findByCdOrName(String cd, String name);
	
	List<TreatmentBodyEntity> findByTreatmentHeaderEntityId(String ID);
	
	List<TreatmentBodyEntity> findByTreatmentHeaderEntityIdIn(List<String> headerIdList);
	
	List<TreatmentBodyEntity> findByProductEntityId(String ID);
}
