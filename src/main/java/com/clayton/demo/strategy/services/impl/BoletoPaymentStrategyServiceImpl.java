package com.clayton.demo.strategy.services.impl;

import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.services.PaymentStrategyService;
import org.springframework.stereotype.Service;

@Service("BOLETO")
public class BoletoPaymentStrategyServiceImpl implements PaymentStrategyService {

    @Override
    public void payment(Payment payment) {
        System.out.printf("Payment type: %s => Valor: %f\n", payment.getPaymentType(), payment.getAmount());
    }
}