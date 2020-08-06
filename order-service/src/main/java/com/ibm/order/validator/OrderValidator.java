package com.ibm.order.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ibm.order.entity.Order;
import com.ibm.order.exception.InvalidPayloadException;

@Component
public class OrderValidator {

	public boolean validate(Order request) {

		if (StringUtils.isEmpty(request.getCustomerName())) {
			throw new InvalidPayloadException("CustomerName can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getOrderDate())) {
			throw new InvalidPayloadException("OrderDate can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getOrderItems())) {
			throw new InvalidPayloadException("OrderItems can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getShippingAddress())) {
			throw new InvalidPayloadException("ShippingAddress can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getTotal())) {
			throw new InvalidPayloadException("Total can't be null or empty");
		}
		return true;
	}
}