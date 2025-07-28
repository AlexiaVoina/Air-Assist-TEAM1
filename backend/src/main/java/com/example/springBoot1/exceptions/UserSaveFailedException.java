package com.example.springBoot1.exceptions;

import org.springframework.http.HttpStatus;

public class UserSaveFailedException extends UserException {


    public UserSaveFailedException(String message,  HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
