package com.pichincha.practica.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pichincha.practica.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long id;
	private Long storeId;
	private String cod;
	private String name;		
	private BigDecimal price;		
	private Long stock;
	private LocalDateTime creationDate = LocalDateTime.now();

	public Product toEntity() {
		return new Product(id, storeId, cod, name, price, stock, creationDate);
	}

}
