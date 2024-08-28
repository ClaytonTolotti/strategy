package com.clayton.demo.strategy.services.v4;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.services.PaymentStrategyService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;

@Service
public class PaymentExecutorImplV4 implements PaymentExecutorV4 {

    @Override
    public void execute(Payment payment) {
        try {
            String packageName = PaymentStrategyService.class.getPackageName();
            String className = "%s.impl.%sPaymentStrategyServiceImpl".formatted(packageName, payment.getPaymentType().getValue());
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            PaymentStrategyService paymentStrategyService = (PaymentStrategyService) constructor.newInstance();
            paymentStrategyService.payment(payment);
        } catch (Exception e) {
            throw new PaymentException(payment.getPaymentType().toString());
        }
    }
}