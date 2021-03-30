package com.dari.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "T_order")
public class Order  {
	
	@Id
	@Column(name = "OR_ID")
	private long orderId;
	
	@Column(name = "OR_stts")
	@Enumerated(EnumType.STRING)
	private OrderStatus stats;
	
	@ManyToOne
	private Delivery delivery;
	
	@OneToOne
	private Cart cart;


}
