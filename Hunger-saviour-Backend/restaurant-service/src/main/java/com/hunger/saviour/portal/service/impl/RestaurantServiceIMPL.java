package com.hunger.saviour.portal.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hunger.saviour.portal.dtos.RestaurantDTO;
import com.hunger.saviour.portal.entities.RestaurantEntity;
import com.hunger.saviour.portal.repository.RestaurantRepository;
import com.hunger.saviour.portal.service.RestaurantService;
import com.hunger.saviour.portal.utilities.RestaurantMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceIMPL implements RestaurantService {

	private final RestaurantRepository restaurantRepository;
	
	@Override
	public Page<RestaurantEntity>  getRestaurants(int pageNumber, int pageSize) {
		
		Page<RestaurantEntity> restaurants = this.restaurantRepository.findAll(PageRequest.of(pageNumber, pageSize));

		return restaurants;
		
	}

	@Override
	public List<RestaurantDTO> getAllRestaurants() {
		
		List<RestaurantEntity> allRestaurants = this.restaurantRepository.findAll();
		
		 return	allRestaurants.stream()
			.map(RestaurantMapper.INSTANCE::entityToDTO).toList();
	}

}
