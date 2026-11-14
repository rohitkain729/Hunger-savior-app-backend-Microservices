package com.hunger.saviour.portal.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.saviour.portal.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

	Optional<List<OrderEntity>> findByUserName(String username);
}
