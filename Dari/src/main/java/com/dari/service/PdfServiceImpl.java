package com.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.repository.AgentRepository;
import com.dari.repository.UserRepository;

@Service
public class PdfServiceImpl implements PdfService {

	@Autowired
	private LoansService loanservice;
	
	@Autowired
	private AgentRepository agentrep;
	
	@Autowired
	private UserRepository userrep;
	
}
