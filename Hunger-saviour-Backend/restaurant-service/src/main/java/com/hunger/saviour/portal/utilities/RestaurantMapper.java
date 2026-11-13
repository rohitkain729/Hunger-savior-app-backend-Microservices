package com.hunger.saviour.portal.utilities;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hunger.saviour.portal.dtos.RestaurantDTO;
import com.hunger.saviour.portal.entities.RestaurantEntity;

@Mapper
public interface RestaurantMapper {

	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	RestaurantDTO entityToDTO(RestaurantEntity entity);
	
}
