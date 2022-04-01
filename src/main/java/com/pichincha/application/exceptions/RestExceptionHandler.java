package com.pichincha.application.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pichincha.application.dto.general.ApiErrorResponseDTO;

@ControllerAdvice
public class RestExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(RestExceptionHandler.class.getName());
	
//   @ExceptionHandler(value=UnauthorizedException.class)
//   public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException e) {
//		return new ResponseEntity<Object>(
//				new ApiErrorResponseDTO(HttpStatus.UNAUTHORIZED.value(), false, e.getMessage(), 
//						e.getData()!=null?new Object[] {e.getData()}:new Object[]{}
//					), HttpStatus.UNAUTHORIZED);
//   }

	@ExceptionHandler(value= Exception.class)
	public ResponseEntity<Object> handleAllExceptions(final Exception ex) {
		logger.error(ExceptionUtils.getStackTrace(ex));
		
		return new ResponseEntity<Object>(
				new ApiErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, 
						ex.getMessage(),
						new Object[] {ExceptionUtils.getStackTrace(ex)}
				), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=CustomExceptionHandler.class)
	public final ResponseEntity<Object> handleCustomExceptions(CustomExceptionHandler e) {
		return new ResponseEntity<Object>(
				new ApiErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), false, 
						e.getMessage()!=null?e.getMessage():HttpStatus.BAD_REQUEST.name(), 
						e.getData()!=null?new Object[] {e.getData()}:new Object[]{}
					), HttpStatus.BAD_REQUEST);
	}
}
