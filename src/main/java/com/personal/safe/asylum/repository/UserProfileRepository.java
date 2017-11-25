package com.personal.safe.asylum.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.personal.safe.asylum.entity.UserProfile;

@Repository
public interface UserProfileRepository extends ReactiveMongoRepository<UserProfile, String>{

}
