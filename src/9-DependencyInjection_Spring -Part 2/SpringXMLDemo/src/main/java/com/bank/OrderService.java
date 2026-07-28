package com.bank;

public class OrderService {

    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    public void placeOrder() {

        System.out.println("Order Placed");

        paymentService.pay();
    }
}
