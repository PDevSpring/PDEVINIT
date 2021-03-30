package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dari.model.Bank;
import com.dari.repository.BankRepository;

public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;
	
	
	@Override
	public List<Bank> getAllBank() {
		List<Bank> bank = (List<Bank>) bankRepository.findAll();
		return bank ; 
	}
	
	
	public long addbank(Bank bank) {
		bankRepository.save(bank);
		return bank.getBankId();
		
	}
	
	
	public Bank updateBank (Bank bank) {
		return bankRepository.save(bank);
	}
	
	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}
	

	@Override
	public Bank getBankByName(String nameBank) {
		return  bankRepository.findByNamebank(nameBank);
		
	}
	
	@Override
	public Bank getBankById(Long id) {	
		Bank bank = bankRepository.findById(id).get();
		return bank;
		
	}
}
