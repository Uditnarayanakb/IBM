package com.bank;

public class UPIPaymentService implements PaymentService {

    @Override
    public void pay() {

        System.out.println("UPI Payment Done");
    }
}