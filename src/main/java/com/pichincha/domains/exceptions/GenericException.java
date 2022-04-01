package com.pichincha.domains.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenericException extends RuntimeException {

  @Getter
  final String message;
  @Getter
  final HttpStatus statusCode;

  public GenericException(HttpStatus statusCode, String message) {
    super(message);
    this.message = message;
    this.statusCode = statusCode;
  }
}
