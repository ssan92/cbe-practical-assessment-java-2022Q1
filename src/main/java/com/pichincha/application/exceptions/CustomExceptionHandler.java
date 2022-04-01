package com.pichincha.application.exceptions;

import lombok.Getter;

@Getter
public class CustomExceptionHandler extends RuntimeException {
	
	private Object data;

	public CustomExceptionHandler(String message, Object data) {
		super(message);
		this.data = data;
	}

	public CustomExceptionHandler(Throwable cause) {
		super(cause);
	}
}
