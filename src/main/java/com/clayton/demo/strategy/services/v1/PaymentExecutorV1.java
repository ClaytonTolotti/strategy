package com.clayton.demo.strategy.services.v1;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;

public interface PaymentExecutorV1 {

    void execute(Payment payment) throws PaymentException;
}