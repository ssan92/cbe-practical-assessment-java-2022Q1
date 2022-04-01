package com.pichincha.practica.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pichincha.practica.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends Base {
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tienda", insertable = false, updatable = false, nullable = false)
	private Store store;

	@Column(name = "tienda")
	private Long storeId;
	
	@Column(name = "codigo")
	private String cod;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "precio", columnDefinition = "DECIMAL(10, 2) DEFAULT 0.0")
	private BigDecimal price = new BigDecimal(0.00);
	
	@Column(name = "stock")
	private Long stock;
		
	public Product(Long id, Long storeId, String cod, String name, BigDecimal price, Long stock, LocalDateTime creationDate) {
		this.id = id;
		this.storeId = storeId;
		this.cod = cod;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.creationDate = creationDate;
	}
	
	public ProductDTO toDTO() {
		return new ProductDTO(id, storeId, cod, name, price, stock, creationDate);
	}
}
