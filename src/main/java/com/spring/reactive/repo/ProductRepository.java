package com.spring.reactive.repo;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.spring.reactive.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
