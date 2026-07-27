package com.bank;

public class CreditCardPaymentService implements PaymentService {

    @Override
    public void makePayment(double amount) {

        System.out.println("Payment of Rs." + amount +
                " made using Credit Card");

    }
}