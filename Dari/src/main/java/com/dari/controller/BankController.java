package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Bank;
import com.dari.service.BankService;
import com.dari.service.UserService;

@Controller


@RestController
@RequestMapping("/Bank")
public class BankController {

	
private List<Bank> banks;
	
	@Autowired
	UserService UsersService;
	@Autowired
	UserController UsersController;
	
	@Autowired
	private BankService bankService ; 
	
	
	
	
	@GetMapping("/addBank")
	public String AddB (@RequestBody Bank bank) {
	bankService.addbank(bank);
	return "Add Bank Done! ";
	}
	
	@PutMapping("/updateBank")
	@ResponseBody
	public Bank updateBank (@RequestBody Bank bank) {
	return bankService.updateBank(bank);
	}
	
	@DeleteMapping("/deleteBank/{bankId}")
	
	public void deleteBankByID(@PathVariable("bankId") Long bankId) {
		bankService.deleteBankByID(bankId);
	}
	
	@GetMapping("/getBankById/{id}")
	@ResponseBody
	public Bank getBankById(@PathVariable("id") Long id) {
		return bankService.getBankById(id);
	}
}
