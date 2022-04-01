package com.pichincha.centrodigital.chapter.eva.controller;

import com.pichincha.centrodigital.chapter.eva.dto.ErrorDto;
import com.pichincha.centrodigital.chapter.eva.exception.ShopNotFountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class Advice {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> handleException(Exception exception, WebRequest req) {
    log.error("Error: {}", exception.getLocalizedMessage(), exception);

    final var errorDto = ErrorDto.builder()
        .message(exception.getLocalizedMessage())
        .build();

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
  }

  @ExceptionHandler(ShopNotFountException.class)
  public ResponseEntity<ErrorDto> customHandleException(ShopNotFountException exception,
      WebRequest req) {
    log.error("Error: {}", exception.getLocalizedMessage(), exception);

    final var errorDto = ErrorDto.builder()
        .code("SHOP-ERROR-01")
        .message(exception.getMessage())
        .build();

    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
  }

}
