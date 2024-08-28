package com.clayton.demo.strategy.services.v2;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;

public interface PaymentExecutorV2 {

    void configure();

    void execute(Payment payment)  throws PaymentException;
}