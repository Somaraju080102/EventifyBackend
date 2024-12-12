package com.recipe.security.eventify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.security.eventify.entity.UserPublicInfo;
import com.recipe.security.eventify.service.UserSignupService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	UserSignupService signupService;
	
	@PostMapping("/signup")
	public String  userRegister(@RequestBody UserPublicInfo publicInfo){
		System.out.println("Called");
		
		signupService.saveUserInfo(publicInfo);
		return "Sucess";		
	}
	
	@GetMapping("/ded")
	public String welcomeMsg() {
		return "Hello Eventify";
	}
}
