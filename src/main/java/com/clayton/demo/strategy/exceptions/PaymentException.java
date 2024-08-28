package com.clayton.demo.strategy.exceptions;

public class PaymentException extends RuntimeException {

    public PaymentException(String msg) {
        super("Payment type: %s not implemented".formatted(msg));
    }
}