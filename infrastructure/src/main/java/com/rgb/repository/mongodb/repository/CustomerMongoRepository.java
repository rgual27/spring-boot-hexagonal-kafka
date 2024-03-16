package com.rgb.repository.mongodb.repository;

import com.rgb.repository.mongodb.entity.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMongoRepository extends MongoRepository<CustomerDocument, String> { }
