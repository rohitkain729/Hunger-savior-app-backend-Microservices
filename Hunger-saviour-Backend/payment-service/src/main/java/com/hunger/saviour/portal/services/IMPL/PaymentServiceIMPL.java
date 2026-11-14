package com.hunger.saviour.portal.services.IMPL;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.hunger.saviour.portal.broker.OrderBroker;
import com.hunger.saviour.portal.dtos.OrderDTO;
import com.hunger.saviour.portal.entities.PaymentEntity;
import com.hunger.saviour.portal.entities.PaymentStatus;
import com.hunger.saviour.portal.repositories.PaymentRepository;
import com.hunger.saviour.portal.services.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceIMPL implements PaymentService{

	private final PaymentRepository paymentRepo;
	private final OrderBroker orderBroker;
	
	@Override
	public void processPayment(OrderDTO orderDTO) {

		PaymentEntity paymentEntity = PaymentEntity.builder()
		.paymentStatus(PaymentStatus.PAYMENT_SUCCESS)
		.transcationId(orderDTO.getTranscationId())
		.userName(orderDTO.getUserName())
		.txDateAndTime(LocalDateTime.now())
		.build();
		
		this.paymentRepo.save(paymentEntity);
		// make a call to order service to create order
		orderDTO.setPaymentId(paymentEntity.getPaymentId());
		this.orderBroker.createOrder(orderDTO);
		
	}

}
