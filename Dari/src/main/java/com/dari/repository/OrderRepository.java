package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
