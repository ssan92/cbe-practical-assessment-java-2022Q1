package com.pichincha.dto;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDto {
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int id;

	private String cod;

	private String name;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private double price;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@Min(value = 0, message = "El stock a actualizar no puede ser menor o igual a cero")
	private long stock;

	public ProductDto(String cod, String name) {
		this.cod = cod;
		this.name = name;
	}
}
