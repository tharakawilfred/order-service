package com.ibm.order.proxy;

import javax.websocket.server.PathParam;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.ibm.order.model.OrderItem;

@FeignClient
public interface OrderItemServiceProxy {

	@GetMapping("http://localhost:8080/v1/orderitem/{orderitemid}")
	public ResponseEntity<OrderItem> getOrderItems(@PathParam("orderitemid") String orderitemid);
}
