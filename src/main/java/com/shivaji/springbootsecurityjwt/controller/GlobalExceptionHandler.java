package com.shivaji.springbootsecurityjwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Incorrect username or password")
    @ExceptionHandler(BadCredentialsException.class)
    public void handleBadCredentialsException() {
        logger.error("BadCredentialsException handler executed");
    }
}
