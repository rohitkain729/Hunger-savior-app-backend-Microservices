package com.hunger.saviour.portal.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunger.saviour.portal.dtos.OrderDTO;
import com.hunger.saviour.portal.services.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentAPI {

	private final PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<?> processPayment(@RequestBody OrderDTO orderDTO){
		log.info("entered into payment api with data:"+ orderDTO.getOrderId());
		this.paymentService.processPayment(orderDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
