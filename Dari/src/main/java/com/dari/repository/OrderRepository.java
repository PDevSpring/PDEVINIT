package com.dari.repository;

import org.springframework.data.repository.CrudRepository;

import com.dari.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
