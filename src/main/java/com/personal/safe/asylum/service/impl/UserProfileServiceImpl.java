package com.personal.safe.asylum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.personal.safe.asylum.entity.UserProfile;
import com.personal.safe.asylum.repository.UserProfileRepository;
import com.personal.safe.asylum.service.UserProfileService;

import reactor.core.publisher.Mono;

@Configuration
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	public Mono<UserProfile> save(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	public Mono<UserProfile> serachUserProfile(UserProfile userProfile) {
		Mono<UserProfile> fectchedUserProfile = userProfileRepository.findByFaceId(userProfile.getFaceId());
		if (fectchedUserProfile == null) {
			fectchedUserProfile = userProfileRepository.findByCellNumber(userProfile.getCell_number());
		}
		if (fectchedUserProfile == null) {
			fectchedUserProfile = userProfileRepository.findByEmailId(userProfile.getEmailId());
		}

		return fectchedUserProfile;
	}

}
