package com.cinovation.web.service.maintenance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cinovation.web.entity.maintenance.TitleEntity;

public interface TitleService {
	
	Page<TitleEntity> getTitleTable(Pageable pageable);
	
	List<TitleEntity> getTitleList();
	
	TitleEntity getTitleListById(String ID);
	
	TitleEntity saveTitle(TitleEntity dataContainer) throws Exception;
	
	TitleEntity updateTitle(TitleEntity dataContainer) throws Exception;
	
	TitleEntity deleteTitleById(String ID) throws Exception;
	
}
