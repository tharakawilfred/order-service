package com.ibm.order.exception;

public class InvalidPayloadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPayloadException(final String message) {
		super(message);
	}
}
