package com.spring.reactive.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reactive.dto.ProductDto;
import com.spring.reactive.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public @ResponseBody Flux<ProductDto> getProducts(){
		
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Mono<ProductDto> getProduct(@PathVariable String id){
		
		return productService.getProduct(id);
	}
	
	@PostMapping
	public Mono<ProductDto> saveProduct(@Valid @RequestBody Mono<ProductDto> product){
		
		return productService.saveProduct(product);
	}
	
	@PutMapping
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> product, @PathVariable String id){
		
		return productService.updateProduct(product, id);
	}
	
	public Mono<Void> deleteProduct(@PathVariable String id){
		return productService.deleteProduct(id); 	
		
	}
}
