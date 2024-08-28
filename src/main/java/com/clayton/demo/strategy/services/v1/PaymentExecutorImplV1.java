package com.clayton.demo.strategy.services.v1;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.models.PaymentType;
import com.clayton.demo.strategy.services.PaymentStrategyService;
import com.clayton.demo.strategy.services.impl.BoletoPaymentStrategyServiceImpl;
import com.clayton.demo.strategy.services.impl.CreditCardPaymentStrategyServiceImpl;
import com.clayton.demo.strategy.services.impl.PixPaymentStrategyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentExecutorImplV1 implements PaymentExecutorV1 {

    @Override
    public void execute(Payment payment) throws PaymentException {
        PaymentStrategyService paymentStrategyService;

        if (payment.getPaymentType().equals(PaymentType.CREDIT_CARD)) {
            paymentStrategyService = new CreditCardPaymentStrategyServiceImpl();
        } else if (payment.getPaymentType().equals(PaymentType.BOLETO)) {
            paymentStrategyService = new BoletoPaymentStrategyServiceImpl();
        } else if (payment.getPaymentType().equals(PaymentType.PIX)) {
            paymentStrategyService = new PixPaymentStrategyServiceImpl();
        } else {
            throw new PaymentException(payment.getPaymentType().toString());
        }
        paymentStrategyService.payment(payment);
    }
}