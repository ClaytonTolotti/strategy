package com.clayton.demo.strategy.controllers;

import com.clayton.demo.strategy.exceptions.PaymentException;
import com.clayton.demo.strategy.models.Payment;
import com.clayton.demo.strategy.services.v1.PaymentExecutorV1;
import com.clayton.demo.strategy.services.v2.PaymentExecutorV2;
import com.clayton.demo.strategy.services.v3.PaymentExecutorV3;
import com.clayton.demo.strategy.services.v4.PaymentExecutorV4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentExecutorV1 paymentExecutorV1;

    @Autowired
    private PaymentExecutorV2 paymentExecutorV2;

    @Autowired
    private PaymentExecutorV3 paymentExecutorV3;

    @Autowired
    private PaymentExecutorV4 paymentExecutorV4;


    @PostMapping("v1/payments")

    public ResponseEntity<Void> paymentsV1(@RequestBody Payment payment) throws PaymentException {
        paymentExecutorV1.execute(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("v2/payments")
    public ResponseEntity<Void> paymentsV2(@RequestBody Payment payment) throws PaymentException {
        paymentExecutorV2.execute(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("v3/payments")
    public ResponseEntity<Void> paymentsV3(@RequestBody Payment payment) throws PaymentException {
        paymentExecutorV3.execute(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("v4/payments")
    public ResponseEntity<Void> paymentsV4(@RequestBody Payment payment) throws PaymentException {
        paymentExecutorV4.execute(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}