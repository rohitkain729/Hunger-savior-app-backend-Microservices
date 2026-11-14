package com.hunger.saviour.portal.apis;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunger.saviour.portal.dtos.OrderDTO;
import com.hunger.saviour.portal.services.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderAPI {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
		this.orderService.createOrder(orderDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<List<OrderDTO>>  getOrders(@PathVariable("username")String username){
		return new ResponseEntity<List<OrderDTO>>(orderService.getOrdersByUsername(username),HttpStatus.OK);
	}
	

}
