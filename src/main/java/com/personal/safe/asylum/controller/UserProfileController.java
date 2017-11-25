package com.personal.safe.asylum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.safe.asylum.entity.UserProfile;
import com.personal.safe.asylum.repository.UserProfileRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
public class UserProfileController {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@GetMapping("/userProfiles")
	public Flux<UserProfile> getAllUsers() {
		return userProfileRepository.findAll();
	}

	@PostMapping("/userProfiles")
	public Mono<UserProfile> createUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	@GetMapping("/userProfiles/{id}")
	public Mono<ResponseEntity<UserProfile>> getUserProfileById(@PathVariable(value = "id") String userProfileId) {

		return userProfileRepository.findById(userProfileId)
				.map(savedUserProfile -> ResponseEntity.ok(savedUserProfile))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}
}
