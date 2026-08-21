package com.example.domain;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        // ENTITY
        Customer customer = new Customer(1L, "John");

        System.out.println("Before Change:");
        System.out.println(customer);

        customer.setName("John Smith");

        System.out.println("After Change:");
        System.out.println(customer);

        Customer anotherCustomer =
                new Customer(1L, "Different Name");

        System.out.println(
                "Same Customer? " +
                        customer.equals(anotherCustomer)
        );


        // VALUE OBJECT
        Money money1 =
                new Money(new BigDecimal("100"), "USD");

        Money money2 =
                new Money(new BigDecimal("100"), "USD");

        System.out.println(
                "Money Objects Equal? " +
                        money1.equals(money2)
        );
    }
}