package com.hunger.saviour.portal.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hunger.saviour.portal.dtos.RestaurantDTO;
import com.hunger.saviour.portal.entities.RestaurantEntity;

public interface RestaurantService {

	public Page<RestaurantEntity>  getRestaurants(int pageNumber, int pageSize);
	public List<RestaurantDTO>  getAllRestaurants();
	RestaurantDTO getRestaurantById(Integer restaurantId);
	
}
