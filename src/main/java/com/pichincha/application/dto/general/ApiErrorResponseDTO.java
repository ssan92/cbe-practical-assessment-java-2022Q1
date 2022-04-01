package com.pichincha.application.dto.general;

import lombok.Getter;

@Getter
public class ApiErrorResponseDTO {

	private Integer code;
	private boolean success;
	private String message;
	private Object errorData;

	public ApiErrorResponseDTO(Integer code, boolean success, String message, Object errorData) {
		super();
		this.code = code;
		this.success = success;
		this.message = message;
		this.errorData = errorData;
	}
}
