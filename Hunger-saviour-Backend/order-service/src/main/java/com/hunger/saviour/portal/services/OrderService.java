package com.hunger.saviour.portal.services;

import java.util.List;

import com.hunger.saviour.portal.dtos.OrderDTO;

public interface OrderService {
	
	void createOrder(OrderDTO orderDTO);
	List<OrderDTO>  getOrdersByUsername(String userName);
}
