package com.hunger.saviour.portal.services.IMPL;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hunger.saviour.portal.dtos.OrderDTO;
import com.hunger.saviour.portal.entities.OrderEntity;
import com.hunger.saviour.portal.repositories.OrderRepository;
import com.hunger.saviour.portal.services.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceIMPL implements OrderService {

	private final OrderRepository orderRepository;

	@Override
	public void createOrder(OrderDTO orderDTO) {
		OrderEntity orderEntity = OrderEntity.builder()
		.transactionId(orderDTO.getTranscationId())
				.userName(orderDTO.getUserName())
				.paymentId(orderDTO.getPaymentId())
				.orderCreatedTime(LocalDateTime.now())
				.orderStatus("Delivered")
				.amountPaid(orderDTO.getAmountPaid())
				.build();
		orderRepository.save(orderEntity);
	}

	@Override
	public List<OrderDTO> getOrdersByUsername(String userName) {

//		List<OrderEntity> orderEntityList = this.orderRepository.findByUserName(userName).orElseThrow(()-> new RuntimeException("user name not found"));
//		
//		List<OrderDTO>  orderDtoList = orderEntityList.stream()
//		.map(order -> OrderDTO.builder()
//				.orderId(order.getOrderId())
//				.paymentId(order.getPaymentId())
//				.userName(order.getUserName())
//				.orderCreatedTime(order.getOrderCreatedTime())
//				.transcationId(order.getTransactionId())
//				.amountPaid(order.getAmountPaid())
//				.orderStatus(order.getOrderStatus())
//				.build()).toList();
		
		Optional<List<OrderEntity>> orderEntityList = this.orderRepository.findByUserName(userName);
		
		List<OrderDTO> orderDtoList = orderEntityList.map(orders -> orders.stream()
				.map(order -> OrderDTO.builder()
						.orderId(order.getOrderId())
						.paymentId(order.getPaymentId())
						.userName(order.getUserName())
						.orderCreatedTime(order.getOrderCreatedTime())
						.transcationId(order.getTransactionId())
						.amountPaid(order.getAmountPaid())
						.orderStatus(order.getOrderStatus())
						.build()).toList()
				
				).orElse(Collections.emptyList());
		
		return orderDtoList;
	}

}
