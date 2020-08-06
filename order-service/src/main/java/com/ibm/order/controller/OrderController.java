package com.ibm.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.order.entity.Order;
import com.ibm.order.exception.InvalidPayloadException;
import com.ibm.order.exception.OrderNotFoundException;
import com.ibm.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	protected OrderService service;

	@PostMapping("/v1/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order) {

		Order response = service.createOrder(order);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/v1/order/retrieve")
	public ResponseEntity<?> retrieveOrderItems() throws OrderNotFoundException {

		List<Order> response = service.retrieveOrders();
		return ResponseEntity.ok(response);
	}
	
	@ExceptionHandler(InvalidPayloadException.class)
	public ResponseEntity<?> handleException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}