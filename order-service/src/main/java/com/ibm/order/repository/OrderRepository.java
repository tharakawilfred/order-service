package com.ibm.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.order.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}