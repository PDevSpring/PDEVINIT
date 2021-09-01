package com.dari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_Delivery")
public class Delivery {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEL_ID")
	private int deliveryId;
	
	@Column(name = "DEL_NAME")
	private String name;
	
	@Column(name = "DEL_ADR")
	private String adress;
	
	@Column(name = "DEL_INFO")
	private String moreinfo;
	
	//@OneToMany
		//private Order order;
}
