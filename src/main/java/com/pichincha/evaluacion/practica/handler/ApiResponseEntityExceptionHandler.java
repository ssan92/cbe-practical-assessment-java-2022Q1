package com.pichincha.evaluacion.practica.handler;

import com.pichincha.evaluacion.practica.dto.ApiError;
import com.pichincha.evaluacion.practica.handler.exceptions.BadRequestMatchException;
import com.pichincha.evaluacion.practica.handler.exceptions.CannotExecuteActionException;
import com.pichincha.evaluacion.practica.handler.exceptions.GeneralErrorException;
import com.pichincha.evaluacion.practica.handler.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class ApiResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setType("Not Found");
        apiError.setTitle("Recurso no encontrado.");
        apiError.detail("No se han encontrado datos para la operacion.");
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setInstance("");
        return apiError;
    }

    @ExceptionHandler(value = {CannotExecuteActionException.class})
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ApiError cannotExecuteActionException(CannotExecuteActionException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTitle("Acceso no permitido.");
        apiError.detail("No tiene la autoridad suficiente para esta accion.");
        apiError.setStatus(HttpStatus.FORBIDDEN.value());
        apiError.setInstance("");
        return apiError;
    }

    @ExceptionHandler(value = {BadRequestMatchException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError illegalArgumentException(BadRequestMatchException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setType("Solicitud Incorrecta");
        apiError.setTitle("Solicitud incorrecta.");
        apiError.detail("Valores del campo identificación vacio o inválido");
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setInstance("");
        return apiError;
    }

    @ExceptionHandler(value = {GeneralErrorException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError generalError(GeneralErrorException ex, WebRequest request) {
        log.error("GeneralErrorException: ", ex);
        ApiError apiError = new ApiError();
        apiError.setTitle("Ocurrio un error");
        apiError.detail("Ocurrio un error.");
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return apiError;
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError jwtDecodeCustomException(Exception ex, WebRequest request) {
        log.error("Exception: ", ex);
        ApiError apiError = new ApiError();
        apiError.setType("General Error");
        apiError.setTitle("Ocurrio un error");
        apiError.detail("Ocurrio un error");
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return apiError;
    }
}