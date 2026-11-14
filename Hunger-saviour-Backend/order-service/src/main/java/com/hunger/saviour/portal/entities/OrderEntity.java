package com.hunger.saviour.portal.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID orderId;
	@Column(name = "payment_id")
	private UUID paymentId;
	@Column(name = "transaction_id")
	private String transactionId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "amount_paid")
	private Double amountPaid;
	@Column(name = "order_created_time")
	private LocalDateTime orderCreatedTime;
	@Column(name = "order_status")
	private String orderStatus;
}





