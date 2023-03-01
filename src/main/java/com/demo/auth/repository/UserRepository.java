package com.demo.auth.repository;

import com.demo.auth.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserEntity, Long> {
    @Query("{email: '?0")
    UserEntity findByEmail(String email);
}