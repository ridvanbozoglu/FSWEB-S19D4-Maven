package com.workintech.s19d1.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter

public class ApiException extends RuntimeException{
    private HttpStatus httpStatus;
    public ApiException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}