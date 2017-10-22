package com.cinovation.web.service.treatment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

import com.cinovation.web.entity.treatment.ProductEntity;
import com.cinovation.web.repository.treatment.ProductRepository;

@Service
@RepositoryEventHandler
public class ProductServiceImpl implements ProductService{

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository ProductRepository;
	
	@Override
	public List<ProductEntity> getProductList() {
		return ProductRepository.findAll();
	}
}
