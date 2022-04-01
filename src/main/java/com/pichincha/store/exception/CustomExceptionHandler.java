package com.pichincha.store.exception;

import static lombok.AccessLevel.PRIVATE;

import com.google.gson.JsonObject;
import javax.persistence.NoResultException;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@FieldDefaults(level = PRIVATE)
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity handleHttpException(NoResultException exception) {
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("code","500");
        jsonObject.addProperty("message","invalid references: " + exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(jsonObject.toString()).build();
    }
}
