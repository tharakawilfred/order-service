package com.ibm.order.exception;

public class OrderNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(final String message) {
		super(message);
	}
}
