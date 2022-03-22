package com.spring.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import com.spring.reactive.repo.ProductRepository;
import com.spring.reactive.dto.*;
import com.spring.reactive.util.AppUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Flux<ProductDto> getProducts(){
		return productRepository.findAll().map(AppUtils::entityToDto);
	}
	
	public Mono<ProductDto> getProduct(String id){
		return productRepository.findById(id).map(AppUtils::entityToDto);
	}
	
	public Mono<ProductDto> saveProduct( Mono<ProductDto>  productDto){
		return 
				productDto.map(AppUtils::dtoToEntity).flatMap(productRepository::insert).map(AppUtils::entityToDto);
		
	}
	
	public Mono<ProductDto> updateProduct( Mono<ProductDto>  productDto, String id){
		
		return productRepository.findById(id)
		   .flatMap(p->productDto.map(AppUtils::dtoToEntity))
		   .doOnNext(e -> e.setId(id))
		   .flatMap(productRepository::save)
		   .map(AppUtils::entityToDto);
	}
	
	
	public Mono<Void> deleteProduct(String id){
		return productRepository.deleteById(id); 	
		
	}
 }
