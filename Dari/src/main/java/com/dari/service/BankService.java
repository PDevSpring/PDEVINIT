package com.dari.service;

import java.util.List;

import com.dari.model.Bank;

public interface BankService {

	long addbank(Bank bank);
	Bank updateBank (Bank bank);
	void deleteBankByID(Long bankID);
	Bank getBankByName(String nameBank);
	Bank getBankById(Long id);
	List<Bank> getAllBank();
}
