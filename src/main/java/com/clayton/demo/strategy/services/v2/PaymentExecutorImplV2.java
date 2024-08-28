package com.clayton.demo.strategy.services.v2;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.models.PaymentType;
import com.clayton.demo.strategy.services.PaymentStrategyService;
import com.clayton.demo.strategy.services.impl.BoletoPaymentStrategyServiceImpl;
import com.clayton.demo.strategy.services.impl.CreditCardPaymentStrategyServiceImpl;
import com.clayton.demo.strategy.services.impl.PixPaymentStrategyServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentExecutorImplV2 implements PaymentExecutorV2 {

    private final Map<String, PaymentStrategyService> paymentServiceMap = new HashMap<>();

    @PostConstruct
    @Override
    public void configure() {
        paymentServiceMap.put(PaymentType.PIX.name(), new PixPaymentStrategyServiceImpl());
        paymentServiceMap.put(PaymentType.BOLETO.name(), new BoletoPaymentStrategyServiceImpl());
        paymentServiceMap.put(PaymentType.CREDIT_CARD.name(), new CreditCardPaymentStrategyServiceImpl());
    }

    @Override
    public void execute(Payment payment) {
        try {
            paymentServiceMap.get(payment.getPaymentType().name()).payment(payment);
        } catch (Exception e) {
            throw new PaymentException(payment.getPaymentType().toString());
        }
    }
}