package com.example.springBoot1.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidUserIdException extends UserException {
    public InvalidUserIdException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
