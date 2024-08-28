package com.clayton.demo.strategy.services.v3;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.services.PaymentStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PaymentExecutorImplV3 implements PaymentExecutorV3 {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void execute(Payment payment) throws PaymentException {

        try {
            PaymentStrategyService paymentStrategyService = (PaymentStrategyService) applicationContext.getBean(payment.getPaymentType().toString());
            paymentStrategyService.payment(payment);
        } catch (Exception e) {
            throw new PaymentException(payment.getPaymentType().toString());
        }
    }
}