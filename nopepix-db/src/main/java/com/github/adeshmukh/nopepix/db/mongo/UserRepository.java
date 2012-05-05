package com.github.adeshmukh.nopepix.db.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.adeshmukh.nopepix.model.photo.User;

public interface UserRepository extends MongoRepository<User, String> {

    
}
