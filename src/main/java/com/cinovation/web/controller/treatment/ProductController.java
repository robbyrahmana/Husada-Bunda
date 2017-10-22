package com.cinovation.web.controller.treatment;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinovation.web.dto.treatment.ProductDto;
import com.cinovation.web.entity.treatment.ProductEntity;
import com.cinovation.web.helper.DataConverter;
import com.cinovation.web.service.treatment.ProductService;

@RestController
@RequestMapping(value = "/treatment/product")
public class ProductController extends DataConverter {

	@Inject
	ProductService productService;
	
	public ProductController() {
		server = ProductEntity.class;
		view = ProductDto.class;
	}
	
	@RequestMapping(value = "/getListAction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public List<ProductDto> getList() {
		
        List<ProductEntity> page = productService.getProductList();
    	
    	return viewDataList(page);
    }
}
