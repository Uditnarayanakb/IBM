package com.bank;

public class DebitCardPaymentService implements PaymentService {

    @Override
    public void makePayment(double amount) {

        System.out.println("Payment of Rs." + amount +
                " made using Debit Card");

    }
}