package com.hunger.saviour.portal.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "payments")
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID paymentId;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	@Column(name = "txn_date_time")
	private LocalDateTime txDateAndTime;
	@Column(name = "username")
	private String userName;
	@Column(name = "txn_id")
	private String transcationId;
}
