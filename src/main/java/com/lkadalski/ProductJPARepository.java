package com.lkadalski;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductJPARepository extends MongoRepository<Product, Integer> {
}
