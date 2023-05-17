package com.urlshortner.urlshortningservice.exception;

import lombok.Data;

@Data
public class ExceptionResponse {
    String message;
    String url;
}
