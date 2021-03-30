package com.dari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId ; 
	
	@Column(name = "Number_fur")
	private int NumberFur;
	
	@Column(name = "Totalpri")
	private float Totalpri ; 
	
	@ManyToOne
	private Fourniture article;
	
	
	@OneToOne(mappedBy="cart")
	private Order order;

}

