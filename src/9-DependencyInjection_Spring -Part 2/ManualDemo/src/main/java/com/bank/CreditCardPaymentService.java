package com.bank;

public class CreditCardPaymentService
        implements PaymentService {

    @Override
    public void pay() {

        System.out.println("Credit Card Payment Done");
    }
}