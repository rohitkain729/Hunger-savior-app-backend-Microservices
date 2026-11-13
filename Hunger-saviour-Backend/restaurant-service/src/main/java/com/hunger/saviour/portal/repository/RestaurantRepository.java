package com.hunger.saviour.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.saviour.portal.entities.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {

}
