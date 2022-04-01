package com.pichincha.practica.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pichincha.practica.model.Order;
import com.pichincha.practica.model.OrderDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Long id;	
	private Long userId;
	private Long storeId;
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	private LocalDateTime orderDate;
	private LocalDateTime creationDate = LocalDateTime.now();

	public Order toEntity() {
		return new Order(id, userId, storeId, orderDetails, orderDate, creationDate);
	}

}
