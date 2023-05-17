package com.urlshortner.urlshortningservice.exception;

public class NoResourceFoundException extends Exception{

    public NoResourceFoundException() {
        super();
    }
    public NoResourceFoundException(String message) {
        super(message);
    }
}
