package com.personal.safe.asylum.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.personal.safe.asylum.entity.UserProfile;
import com.personal.safe.asylum.repository.UserProfileRepository;
import com.personal.safe.asylum.service.UserProfileService;

import reactor.core.publisher.Mono;

@Configuration
public class UserProfileServiceImpl implements UserProfileService {

	public StringBuilder message = new StringBuilder(
			"Congratulation's you have been succefully registerd. Please provide the following code to confirm your registration.\n Authorization Code : ");

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private PhoneMessageService phoneMessageService;

	@Autowired
	private EmailService emailService;

	public Mono<UserProfile> save(UserProfile userProfile) {
		Mono<UserProfile> savedUserProfile = userProfileRepository.save(userProfile);
		if (savedUserProfile != null) {
			message.append(generateRandomNumber());
			emailService.prepareAndSend(userProfile.getEmailId(), message.toString());
			phoneMessageService.sendSMS(userProfile.getCell_number(), message.toString());
		}

		return savedUserProfile;
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

	private int generateRandomNumber() {
		return (new Random()).nextInt(900000) + 100000;
	}
}
