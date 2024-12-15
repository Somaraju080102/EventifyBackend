package com.recipe.security.eventify.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisOtpService {
	
	
	
    private final RedisTemplate<String, String> redisTemplate;

    public RedisOtpService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    } 	

    public void sendOtp(String email, String otp) {
    	
        // Store OTP with an expiration time (e.g., 5 minutes)
        redisTemplate.opsForValue().set(email, otp, 5, TimeUnit.MINUTES);
    }

    // Method to validate OTP
    public boolean validateOtp(String email, String otp) {
        String storedOtp = redisTemplate.opsForValue().get(email);
        System.out.println(storedOtp);
        
        if (storedOtp != null && storedOtp.equals(otp)) {
            // OTP matches and is valid
            System.out.println("true");

            return true;
            
            
        }
        return false;
    }
}


