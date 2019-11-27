package com.bisnode;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductJPARepository extends MongoRepository<Product, Integer> {
}
