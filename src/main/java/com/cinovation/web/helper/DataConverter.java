package com.cinovation.web.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@Component
public class DataConverter {

	public Class<?> server = null;
	public Class<?> view = null;
	
	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings({ "unchecked" })
	public <E> List<E> viewDataList(List<?> entity) {
		List<E> records = (List<E>) entity.stream().map(post -> convertToDto(post, view))
				.collect(Collectors.toList());
		
		System.out.println(view.getName() + "=" + records);
		
		return records;
	}
	
	@SuppressWarnings({ "unchecked" })
	public <E> Page<E> viewDataPage(Page<?> entity) {
		Page<E> records = (Page<E>) entity.map(post -> convertToDto(post, view));
		
		System.out.println(view.getName() + "=" + records);
		
		return records;
	}
	
	@SuppressWarnings("unchecked")
	public <E> E viewData(Object entity) {
		E records = (E) convertToDto(entity, view);
		
		System.out.println(view.getName() + "=" + records);
		
		return records;
	}
	
	@SuppressWarnings("unchecked")
	public <E> E serverData(Object entity) {
		E records = (E) convertToEntity(entity, server);
		
		System.out.println(server.getName() + "=" + records);
		
		return records;
	}

	// Map Entity to DTO
	private Object convertToDto(Object entity, Class<?> convert) {
		return modelMapper.map(entity, convert);
	}

	//Map DTO to Entity
	private Object convertToEntity(Object entity, Class<?> convert) throws ParseException {
		return modelMapper.map(entity, convert);
	}
}
