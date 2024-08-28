package com.clayton.demo.strategy.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = {InvalidFormatException.class, Exception.class})
    public ResponseEntity<String> getHttpMessageNotReadableException(InvalidFormatException ex) {
        return new ResponseEntity<>("Payment type: %s not implemented".formatted(ex.getValue()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PaymentException.class})
    public ResponseEntity<String> getPaymentException(PaymentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}