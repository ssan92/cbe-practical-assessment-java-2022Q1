package com.bp.chapter.test.ChapterTest.exception;

import com.bp.chapter.test.ChapterTest.dto.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class StoreException extends Exception{
	
	private static final long serialVersionUID = 1L;

	private String code;
	
	private int responseCode;
	
	private final List<ErrorDto> errorList = new ArrayList<>();

	public StoreException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	
	public StoreException(String code, int responseCode, String message, List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}

	public StoreException() {
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}
	
	

}
