package com.pichincha.application.dto.general;

import java.io.Serializable;

import javax.ws.rs.core.Response.Status;

import lombok.Getter;

@Getter
public class ResponseOkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private boolean success;
	private String message;
	private Object data;	
	
	public ResponseOkDTO(String message, Object data) {
		super();
		this.code = Status.OK.getStatusCode();
		this.success = true;
		this.message = message;
		this.data = data;
	}
}
