package com.clayton.demo.strategy.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentType {

    CREDIT_CARD("CreditCard"),
    PIX("Pix"),
    BOLETO("Boleto"),
    TEST("Test");

    private String value;
}