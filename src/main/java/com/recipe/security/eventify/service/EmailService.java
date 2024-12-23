package com.recipe.security.eventify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public void sendVerificationCode(String to,String subject,String text) {
		System.out.println("Message"+" "+text+" "+subject+" "+to);
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		mailMessage.setFrom("somrajuindukuri080102@gmail.com");
		
		javaMailSender.send(mailMessage);
		
	}

}
