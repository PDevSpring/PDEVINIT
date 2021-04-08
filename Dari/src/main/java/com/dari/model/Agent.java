package com.dari.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Agents")
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idag")
	private long Id;
	private String Firstname;
	private String Lastname;
	private Date datenaissance;
	private String Email;
	private String Password;
	private int Phone;
	private String Adress;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="agentB")
	private Set<Bank> banks;
	
	//private String (long idbank)
	
	
}
