package com.dari.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BankId ; 
	
	public String Namebank;
	
	
	public String Descbank;

	public String Adressbank;

	public String MargeInteretbank;

	private float Taux;
	
	@JsonBackReference
	@ManyToOne
	Agent agentB;

}
