package com.personal.safe.asylum.service;

import com.personal.safe.asylum.entity.UserProfile;

import reactor.core.publisher.Mono;

public interface UserProfileService {

	Mono<UserProfile> save(UserProfile userProfile);
}
