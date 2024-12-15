package com.recipe.security.eventify.entity;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;

@RedisHash("otpinfo")
public class ReddisOtp {
	
	@Id
	private String email;
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

}
