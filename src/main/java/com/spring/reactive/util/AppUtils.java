package com.spring.reactive.util;

import org.springframework.beans.BeanUtils;

import com.spring.reactive.dto.ProductDto;
import com.spring.reactive.entity.Product;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class AppUtils {
	
	public static ProductDto entityToDto(Product product) {
		
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);
		
		return dto;
		
	}
	
	public static Product dtoToEntity(ProductDto dto) {
		
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		
		return entity;
		
	}

}
