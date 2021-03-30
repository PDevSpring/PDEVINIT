package com.dari.service;

import java.util.List;

import com.dari.model.LoansSimulationBank;

public interface LoansService {

	List<LoansSimulationBank> getAllLoans();

	List<LoansSimulationBank> getAllLoansByNameBank(String namebank);

	LoansSimulationBank getLoansById(Long id);

	void deleteLoanById(Long id);

	void confirmLoan(Long idloan);

	void unConfirmLoan(Long idloan);

	LoansSimulationBank approcheLoan();

}
