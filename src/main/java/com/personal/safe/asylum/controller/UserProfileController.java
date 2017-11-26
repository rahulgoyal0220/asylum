package com.personal.safe.asylum.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.personal.safe.asylum.entity.UserProfile;
import com.personal.safe.asylum.repository.UserProfileRepository;
import com.personal.safe.asylum.service.UserProfileService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
public class UserProfileController {

	private final GridFsTemplate gridFsTemplate;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	public UserProfileController(GridFsTemplate gridFsTemplate) {
		this.gridFsTemplate = gridFsTemplate;
	}

	@PostMapping("/userProfiles/image")
	public HttpEntity<byte[]> uploadImage(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();
		System.out.println("File name " + name);
		try {
			gridFsTemplate.store(file.getInputStream(), name, file.getContentType());
			String resp = "<script>window.location = '/';</script>";
			return new HttpEntity<>(resp.getBytes());
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/userProfiles")
	public Flux<UserProfile> getAllUsers() {
		return userProfileRepository.findAll();
	}

	@PostMapping("/userProfiles")
	public Mono<UserProfile> createUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userProfileService.save(userProfile);
	}

	@PostMapping("/userProfiles/search")
	public Mono<UserProfile> searchUserProfile(@RequestBody UserProfile userProfile) {
		return userProfileService.serachUserProfile(userProfile);
	}
	
	@GetMapping("/userProfiles/{id}")
	public Mono<ResponseEntity<UserProfile>> getUserProfileById(@PathVariable(value = "id") String userProfileId) {

		return userProfileRepository.findById(userProfileId)
				.map(savedUserProfile -> ResponseEntity.ok(savedUserProfile))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}
}
