package com.pichincha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteNumeroTransactionDto {

	private String numTransaccion;
	private String nombreTienda;
	private String nombreProducto;
}
