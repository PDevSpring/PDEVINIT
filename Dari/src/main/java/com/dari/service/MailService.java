package com.dari.service;

import org.springframework.mail.MailException;

import com.dari.model.User;

public interface MailService {

	void Send(User user) throws MailException;

}
