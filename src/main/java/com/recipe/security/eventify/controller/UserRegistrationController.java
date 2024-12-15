package com.recipe.security.eventify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.security.eventify.entity.UserPublicInfo;
import com.recipe.security.eventify.service.EmailService;
import com.recipe.security.eventify.service.RedisOtpService;
import com.recipe.security.eventify.service.UserSignupService;

@RestController
public class UserRegistrationController {
	
	
	@Autowired
	RedisOtpService otpService;
	
	@Autowired
	EmailService emailService;

	@Autowired
	UserSignupService signupService;
	
//	@PostMapping("/signup")
//	public String  userRegister(@RequestBody UserPublicInfo publicInfo){
//		System.out.println("Called");
//		
//		signupService.saveUserInfo(publicInfo);
//		return "Sucess";		
//	}
	
	
	@PostMapping("/send-otp")
	public String sendOtp(@RequestBody UserPublicInfo userEmail) {
		
		String otp=signupService.generateOtp();

		String subject="Your Otp Code";
		
		String text="Your OTP Code is :  "+otp;
		
		System.out.println(otp);
		
		
		
//		emailService.sendVerificationCode(userEmail.getUserEmail(), subject, text);
		
		otpService.sendOtp(userEmail.getUserEmail(), otp);
		
		return "Success";
		
		
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestBody UserPublicInfo publicInfo) {
		
		String userEmail=publicInfo.getUserEmail();
		String userOtp=publicInfo.getUserOtp();
		
		if(otpService.validateOtp(userEmail, userOtp)==true) {
			
			signupService.saveUserInfo(publicInfo);
			return "Valid";
		}
		else {
			
		
		return "Invalid or Expired Otp";
		}
	}
	
	
	
	@GetMapping("/ded")
	public String welcomeMsg() {
		return "Hello Eventify";
	}
}
