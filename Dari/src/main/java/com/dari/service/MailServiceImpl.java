package com.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dari.model.User;

@Service
public class MailServiceImpl implements MailService {

	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public void MailingServiceImpl(JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;

	}
	
	@Override
	public void Send(User user) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot.
		 * This JavaMailSender extends the MailSender Interface which contains
		 * send() function. SimpleMailMessage Object is required because send()
		 * function uses object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(user.getEmail());
		mail.setTo("dari@gmail.com");
		mail.setSubject("Test Mail");
		mail.setText("Hhhhhhhhh");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	
	
}
