package com.ibm.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.order.entity.Order;
import com.ibm.order.exception.InvalidPayloadException;
import com.ibm.order.exception.OrderNotFoundException;
import com.ibm.order.model.OrderItem;
import com.ibm.order.proxy.OrderItemServiceProxy;
import com.ibm.order.repository.OrderRepository;
import com.ibm.order.validator.OrderValidator;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	protected OrderValidator validator;

	@Autowired
	protected OrderRepository repository;

	@Autowired
	protected OrderItemServiceProxy proxy;

	@Override
	public Order createOrder(Order order) throws InvalidPayloadException {
		Order response = null;
		if (validator.validate(order)) {
			order.setOrderItems(getOrderItems(order.getItemIds()));
			response = save(order);
			return response;
		}
		return response;
	}

	private List<OrderItem> getOrderItems(List<String> orderItemIds) {

		List<OrderItem> list = new ArrayList<>();
		for (String orderItemId : orderItemIds) {
			list.add(proxy.getOrderItems(orderItemId).getBody());
		}
		return list;
	}

	private Order save(final Order order) {
		return repository.save(order);
	}

	@Override
	public List<Order> retrieveOrders() throws OrderNotFoundException {
		final List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(order -> orders.add(order));

		if (orders.isEmpty()) {
			throw new OrderNotFoundException("No order found");
		}
		return orders;
	}
}