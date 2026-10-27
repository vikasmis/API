package com.example.userapi.exception;

import org.springframework.http.HttpStatus;

public class CustomerException extends RuntimeException {

    private final HttpStatus status;

    public CustomerException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public CustomerException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}