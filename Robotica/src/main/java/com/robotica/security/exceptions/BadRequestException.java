package com.robotica.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
        System.err.println(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        System.err.println(message);
    }
}
