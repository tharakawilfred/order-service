package com.ibm.order.service;

import java.util.List;

import com.ibm.order.entity.Order;
import com.ibm.order.exception.OrderNotFoundException;

public interface OrderService {
	Order createOrder(Order order);

	List<Order> retrieveOrders() throws OrderNotFoundException;
}
