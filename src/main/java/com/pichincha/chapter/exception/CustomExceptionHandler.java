package com.pichincha.chapter.exception;


import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static lombok.AccessLevel.PRIVATE;

@ControllerAdvice
@FieldDefaults(level = PRIVATE)
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(StoreAdministrationException.class)
    public ResponseEntity handleHttpException(StoreAdministrationException exception) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
