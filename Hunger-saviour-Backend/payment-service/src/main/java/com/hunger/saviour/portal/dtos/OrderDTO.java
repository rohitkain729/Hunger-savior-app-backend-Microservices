package com.hunger.saviour.portal.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
	private UUID orderId;
	private UUID paymentId;
	private String transcationId;
	private String userName;
	private Double amountPaid;
	private LocalDateTime orderCreatedTime;
	private String orderStatus;
}
