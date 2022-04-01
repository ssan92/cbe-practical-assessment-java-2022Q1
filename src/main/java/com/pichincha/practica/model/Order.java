package com.pichincha.practica.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pichincha.practica.dto.OrderDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends Base {
	
	@JsonManagedReference("Order")
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "usuario", insertable = false, updatable = false, nullable = false)
	private User user;

	@Column(name = "usuario")
	private Long userId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tienda", insertable = false, updatable = false, nullable = false)
	private Store store;

	@Column(name = "tienda")
	private Long storeId;
	
	@Column(name = "fecha_pedido", nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime orderDate;
	
	public Order(Long id, Long userId, Long storeId,  List<OrderDetail> orderDetails, LocalDateTime orderDate, LocalDateTime creationDate) {
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.orderDate = orderDate;
		this.orderDetails = orderDetails;
		this.creationDate = creationDate;
	}
	
	public OrderDTO toDTO() {
		return new OrderDTO(id, userId, storeId, orderDetails, orderDate,  creationDate);
	}
}
