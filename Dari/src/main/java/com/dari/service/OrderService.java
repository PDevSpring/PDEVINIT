package com.dari.service;

import java.util.List;

import com.dari.model.Order;

public interface OrderService {

	Order addorder(Order c);

	void deleteorderbyId(long orderId);

	Order findOrderbyId(long orderId);


	Order shipcommandebyid(long orderId);

	List<Order> findallorders();

	Order closeOrderbyid(long orderid);

	
}
