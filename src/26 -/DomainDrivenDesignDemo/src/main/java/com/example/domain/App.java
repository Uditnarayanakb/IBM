package com.example.domain;

public class App {

    public static void main(String[] args) {

        com.example.sales.Customer salesCustomer =
                new com.example.sales.Customer(
                        101L,
                        "John",
                        "Bangalore",
                        50000
                );

        com.example.support.Customer supportCustomer =
                new com.example.support.Customer(
                        101L,
                        "John",
                        "Login Issue",
                        "Gold"
                );

        System.out.println(salesCustomer);
        System.out.println(supportCustomer);
    }
}
