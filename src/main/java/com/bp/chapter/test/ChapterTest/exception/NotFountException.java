package com.bp.chapter.test.ChapterTest.exception;

import com.bp.chapter.test.ChapterTest.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFountException extends StoreException{

	private static final long serialVersionUID = 1L;

	public NotFountException(String code, String message) {
		super(code,HttpStatus.NOT_FOUND.value(),message);
	}
	
	public NotFountException(String code, String message, ErrorDto data) {
		super(code,HttpStatus.NOT_FOUND.value(),message, Arrays.asList(data));
	}

}
