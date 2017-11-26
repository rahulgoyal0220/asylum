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

	public StringBuilder createMessage = new StringBuilder(
			"Congratulation's you have been succefully registerd. Please provide the following code to confirm your registration.\n Authorization Code : ");
	
	public StringBuilder updateMessage = new StringBuilder(
			"Congratulation's you have been succefully Identified. Please provide the following code to confirm validate your details.\n Authorization Code : ");

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private PhoneMessageService phoneMessageService;

	@Autowired
	private EmailService emailService;

	public Mono<UserProfile> save(UserProfile userProfile) {
		Mono<UserProfile> savedUserProfile = userProfileRepository.save(userProfile);
		if (savedUserProfile != null) {
			createMessage.append(generateRandomNumber());
			emailService.prepareAndSend(userProfile.getEmailId(), createMessage.toString());
			phoneMessageService.sendSMS(userProfile.getCell_number(), createMessage.toString());
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

	public Mono<UserProfile> update(String id, UserProfile userProfile) {
		Mono<UserProfile> fectchedUserProfile = userProfileRepository.findById(id);

		UserProfile profile = fectchedUserProfile.block();

		profile.setAddresses(userProfile.getAddresses());
		profile.setName(userProfile.getName());
		profile.setGender(userProfile.getGender());
		profile.setEmailId(userProfile.getEmailId());
		profile.setCell_number(userProfile.getCell_number());
		profile.setFaceId(userProfile.getFaceId());

		fectchedUserProfile = userProfileRepository.save(profile);

		if (fectchedUserProfile != null) {
			updateMessage.append(generateRandomNumber());
			emailService.prepareAndSend(userProfile.getEmailId(), updateMessage.toString());
			phoneMessageService.sendSMS(userProfile.getCell_number(), updateMessage.toString());
		}
		return fectchedUserProfile;
	}

	public Mono<UserProfile> verify(String id, String token) {
		Mono<UserProfile> fectchedUserProfile = userProfileRepository.findById(id);
		return fectchedUserProfile;
	}
}
