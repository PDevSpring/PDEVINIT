package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.LoansSimulationBank;
import com.dari.repository.AdsRepository;
import com.dari.repository.AgentRepository;
import com.dari.repository.BankRepository;
import com.dari.repository.LoansRepository;
import com.dari.repository.UserRepository;

@Service
public class LoansServiceImpl implements LoansService {

	
	@Autowired
	LoansRepository loanRepository;
	@Autowired
	BankRepository bankRepository;
	@Autowired
	AgentRepository agentRepository;
	@Autowired
	AdsRepository adsRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<LoansSimulationBank> getAllLoans() {
		return (List<LoansSimulationBank>) loanRepository.findAll();
	}
	
	


	
	@Override
	public List<LoansSimulationBank> getAllLoansByNameBank(String namebank) {
		
		return loanRepository.getAllLoansByNameBank(namebank);
	}
	
	@Override
	public LoansSimulationBank getLoansById(Long id) {

		return loanRepository.findById(id).get();
	}
	
	
	
	//@Override
	//public LoansSimulationBank addLoan(String nameBank,int nbrAnnee,int idImmob,double salaireClient,Long idClient) throws MailException, MessagingException {
	//}

	

	@Override
	public void deleteLoanById(Long id) {
		loanRepository.deleteById(id);	
	}	
		
	@Override
	public void confirmLoan(Long idloan) {
		
		LoansSimulationBank simulation=loanRepository.findById(idloan).get();
		simulation.setStatus("CONFIRMED");
		loanRepository.save(simulation);
		
	}
	
	@Override
	public void unConfirmLoan(Long idloan) {
		
		LoansSimulationBank simulation=loanRepository.findById(idloan).get();
		simulation.setStatus("DENIED");
		loanRepository.save(simulation);
		
	}
	
	@Override
	public LoansSimulationBank approcheLoan() {
		
		return null;}
	///////////////////////////////////////////////////////////////
	//________________calcule___loan___________//
}
