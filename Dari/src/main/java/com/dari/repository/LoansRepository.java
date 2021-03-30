package com.dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dari.model.LoansSimulationBank;

public interface LoansRepository  extends CrudRepository <LoansSimulationBank, Long> {

	@Query(value="SELECT * FROM t_loan l join t_bank b on l.bank_id_bank=b.id_bank WHERE b.name_bank=?1",nativeQuery=true)
	List<LoansSimulationBank> getAllLoansByNameBank(String namebank);


}
