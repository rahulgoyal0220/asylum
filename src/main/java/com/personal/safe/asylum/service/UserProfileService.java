package com.personal.safe.asylum.service;

import com.personal.safe.asylum.entity.UserProfile;

import reactor.core.publisher.Mono;

public interface UserProfileService {

	Mono<UserProfile> save(UserProfile userProfile);
	
	
	Mono<UserProfile> serachUserProfile(UserProfile userProfile);

	Mono<UserProfile> update(String id, UserProfile userProfile);
	
	Mono<UserProfile> verify(String id, String token);
	
}
