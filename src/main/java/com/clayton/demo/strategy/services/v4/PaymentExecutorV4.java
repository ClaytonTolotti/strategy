package com.clayton.demo.strategy.services.v4;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;

public interface PaymentExecutorV4 {

    void execute(Payment payment)  throws PaymentException;
}