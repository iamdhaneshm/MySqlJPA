package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserEntity;
import com.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/createUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
		log.info("create new user called");
		ResponseEntity<UserEntity> response = null;
		UserEntity result = userService.addUser(userEntity);
		response = new ResponseEntity<UserEntity>(result, HttpStatus.OK);
		log.info("end");
		return response;
	};
	
	@GetMapping(path = "/getAllUsers")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		log.info("getAllUsers new user called");
		ResponseEntity<List<UserEntity>> response = null;
		List<UserEntity> result = userService.getAllUser();
		response = new ResponseEntity<List<UserEntity>>(result, HttpStatus.OK);
		log.info("end");
		return response;
	};
	// using @RequestParam
	/*
	 * @GetMapping(path = "/getUser") public ResponseEntity<Optional<UserEntity>>
	 * getUser(@RequestParam int userId) { log.info("getUser new user called");
	 * ResponseEntity<Optional<UserEntity>> response = null; Optional<UserEntity>
	 * result = userService.getUserById(userId); response = new
	 * ResponseEntity<Optional<UserEntity>>(result, HttpStatus.OK); log.info("end");
	 * return response; };
	 */
	
	// using @@PathVariable
	@GetMapping(path = "/getUser/{userId}")
	public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable("userId") int userId) {
		log.info("getUser new user called");
		ResponseEntity<Optional<UserEntity>> response = null;
		Optional<UserEntity> result = userService.getUserById(userId);
		response = new ResponseEntity<Optional<UserEntity>>(result, HttpStatus.OK);
		log.info("end");
		return response;
	};
	
	@PostMapping(path = "/updateUser", produces = "application/json", consumes = "application/json")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity,@RequestParam int userId ) {
		log.info("updateUser new user called");
		ResponseEntity<UserEntity> response = null;
		UserEntity result = userService.updateUserById(userEntity,userId);
		response = new ResponseEntity<UserEntity>(result, HttpStatus.OK);
		log.info("end");
		return response;
	};
	
	@DeleteMapping(path = "/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam int userId ) {
		log.info("deleteUser new user called");
		ResponseEntity<String> response = null;
		String result = userService.deleteUserById(userId);
		response = new ResponseEntity<String>(result, HttpStatus.OK);
		log.info("end");
		return response;
	};
	
	
	
	

}
