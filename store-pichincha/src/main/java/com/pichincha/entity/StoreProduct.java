package com.pichincha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "store_product")
public class StoreProduct {

	@Id
	@Column(name = "store_prod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public StoreProduct(Store store, Product product) {
		this.store = store;
		this.product = product;
	}

}
