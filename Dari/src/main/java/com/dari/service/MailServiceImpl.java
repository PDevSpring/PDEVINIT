package com.dari.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dari.model.Agent;
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
		mail.setText("test test test");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	
	
	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MessagingException
	 */
	
	public void sendEmailWithAttachment(User user,Agent agent,String attachement) throws MailException, MessagingException {

		
		//
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		//pdf file to string
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	
		//
		helper.setTo(agent.getEmail());
		helper.setSubject("Requestiong simulation /");
		helper.setText("here the string pdf file");

		//
		
		File file = new File("link/"+ attachement);
		helper.addAttachment(file.getName(), file);

		javaMailSender.send(mimeMessage);
	}
	
}
