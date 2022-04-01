package com.pichincha.dto;

import lombok.Data;

@Data
public class ReporteMontoTiendaProductoDto {

	private String montoVendido;
	private String nombreTienda;
	private String fecha;

	public ReporteMontoTiendaProductoDto() {
		// TODO Auto-generated constructor stub
	}

	public ReporteMontoTiendaProductoDto(String montoVendido, String nombreTienda, String fecha) {
		this.montoVendido = montoVendido;
		this.nombreTienda = nombreTienda;
		this.fecha = fecha;
	}

}
