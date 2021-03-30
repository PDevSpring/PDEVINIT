package com.dari.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Agent")
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Firstname;
	private String Lastname;
	private Date datenaissance;
	private String Email;
	private String Password;
	private int Phone;
	private String Adress;
	
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="agentB")
	private Set<Bank> banks;
	
}