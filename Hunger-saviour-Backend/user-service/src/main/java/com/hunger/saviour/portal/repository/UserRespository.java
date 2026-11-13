package com.hunger.saviour.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hunger.saviour.portal.entities.UserEntity;

@Repository
public interface UserRespository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUsername(String username);
}
