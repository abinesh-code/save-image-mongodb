package com.example.storeimage;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<ImageEx, String> {
    
}
