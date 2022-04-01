package com.pichincha.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "store_id")
	private Long storeId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "quantity")
	private Long quantity;
	@Column(name = "date")
	private LocalDateTime dateCreation;

	public Transaction(Long storeId, Long productId, Long quantity, LocalDateTime dateCreation) {
		this.storeId = storeId;
		this.productId = productId;
		this.quantity = quantity;
		this.dateCreation = dateCreation;
	}
}
