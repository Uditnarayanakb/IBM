package com.bank;

public class App {

    public static void main(String[] args) {

        UPIPaymentService payment =
                new UPIPaymentService();


        OrderService order =
                new OrderService();

        order.setPaymentService(payment);

        order.placeOrder();
    }
}