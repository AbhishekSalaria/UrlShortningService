package com.urlshortner.urlshortningservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Advice {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleNoResourceFoundException(NoResourceFoundException exception, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setUrl(request.getRequestURI());
        response.setMessage(exception.getMessage());
        return  response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(Exception exception, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setUrl(request.getRequestURI());
        response.setMessage(exception.getMessage());
        return  response;
    }
}
