package com.bank;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(double amount) {

        System.out.println("Order Placed Successfully");

        paymentService.makePayment(amount);

    }
}