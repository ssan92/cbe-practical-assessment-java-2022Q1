package com.bp.chapter.test.ChapterTest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

public class UtilResponse {

    private final static String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    public static HttpStatus getHttpStatus(Integer code) {
        HttpStatus httpStatus = null;
        switch (code) {
            case 200:
                httpStatus = HttpStatus.OK;
                break;
            case 201:
                httpStatus = HttpStatus.CREATED;
                break;
            case 202:
                httpStatus = HttpStatus.ACCEPTED;
                break;
            case 203:
                httpStatus = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
                break;
            case 204:
                httpStatus = HttpStatus.NO_CONTENT;
                break;
            case 205:
                httpStatus = HttpStatus.RESET_CONTENT;
                break;
            case 400:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case 401:
                httpStatus = HttpStatus.UNAUTHORIZED;
                break;
            case 403:
                httpStatus = HttpStatus.FORBIDDEN;
                break;
            case 404:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case 409:
                httpStatus = HttpStatus.CONFLICT;
                break;
            case 460:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case 500:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            case 502:
                httpStatus = HttpStatus.BAD_GATEWAY;
                break;
            case 503:
                httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
                break;
            default:
                httpStatus = HttpStatus.OK;
        }
        return httpStatus;
    }

    /**
     * Funcion que convierte un objeto en un string para imprimir los mensajes
     *
     * @param object
     * @return
     */
    public static String convertObjecttoString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(object);
        } catch (Exception e) {
            System.out.println("Se genero un error en el mètodo de convertObjecttoString" + e.toString());
        }
        return json;
    }




}
