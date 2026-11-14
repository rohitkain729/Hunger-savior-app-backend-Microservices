package com.hunger.saviour.portal.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hunger.saviour.portal.entities.PaymentEntity;


public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
