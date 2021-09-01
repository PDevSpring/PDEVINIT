package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Order;
import com.dari.model.OrderStatus;
import com.dari.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired 
	OrderRepository orderrep;
	
	
	@Override
	public Order addorder(Order c)
	{
		orderrep.save(c);
		return c;
	}
	
	@Override
	public void deleteorderbyId(long orderId)
	{
		orderrep.deleteById(orderId);
	}
	
	@Override
	public Order findOrderbyId(long orderId) {
		return orderrep.findById(orderId).get();
	}
	
	@Override
	public List<Order> findallorders() {
		return (List<Order>) orderrep.findAll();
	}
	
	// SHIPPING COMMANDE
	
	@Override
	public Order shipcommandebyid(long orderId)
	{	
		if( findOrderbyId(orderId).getStats() == OrderStatus.Confirmed )
		{ 
			findOrderbyId(orderId).setStats(OrderStatus.Shipped);	
		}
		return findOrderbyId(orderId);
	}
	
	
	// CLOSING COMMANDE
	
	@Override
	public Order closeOrderbyid(long orderid)
	{	
		if( findOrderbyId(orderid).getStats() ==OrderStatus.Shipped )
		{ 
			findOrderbyId(orderid).setStats(OrderStatus.Done);	
		}
		return findOrderbyId(orderid);
	}

	
}
