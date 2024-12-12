package com.recipe.security.eventify.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.security.eventify.entity.UserPublicInfo;
import com.recipe.security.eventify.repo.UserSignupRepo;

@Service
public class UserSignupService{
	
	@Autowired
	UserSignupRepo signupRepo;
	
	@Autowired
	EmailService emailService;
	
	  private String generatedOtp;
	    private String otpEmail;
	    private long otpTimestamp;
	
	public String generateOtp() {
		Random random=new Random();
		int otp=10000+random.nextInt(900000);
		return String.valueOf(otp);
	}
	
	
	
	public void saveUserInfo(UserPublicInfo info) {
		
		String otp=generateOtp();
		this.generatedOtp=otp;
		this.otpEmail=info.getUserEmail();
		this.otpTimestamp=System.currentTimeMillis();
		
		
		String subject="Your Otp Code";
		
		String text="Your OTP Code is :  "+generatedOtp;
		
		
		emailService.sendVerificationCode(info.getUserEmail(), subject, text);
		
		System.out.println(text);
		
		signupRepo.save(info);
		System.out.println("Db called");

		
		
	}
	public boolean validateOtp(String email,String otp) {
        long expirationTime = 5 * 60 * 1000;  
        if(System.currentTimeMillis()-otpTimestamp>expirationTime) {
        	return false;
        }
        return email.equals(otpEmail)&&otp.equals(generatedOtp);

	}
	

}
