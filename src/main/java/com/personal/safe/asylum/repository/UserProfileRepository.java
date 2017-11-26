package com.personal.safe.asylum.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.personal.safe.asylum.entity.UserProfile;

import reactor.core.publisher.Mono;

@Repository
public interface UserProfileRepository extends ReactiveMongoRepository<UserProfile, String> {
	Mono<UserProfile> findByEmailId(String emailId);

	@Query("{ 'cell_number' : ?0 }")
	Mono<UserProfile> findByCellNumber(String number);
}
