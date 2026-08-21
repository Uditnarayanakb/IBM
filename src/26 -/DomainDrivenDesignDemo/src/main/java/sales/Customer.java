package com.example.sales;

public class Customer {

    private Long customerId;
    private String customerName;
    private String billingAddress;
    private double creditLimit;

    public Customer(Long customerId,
                    String customerName,
                    String billingAddress,
                    double creditLimit) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.billingAddress = billingAddress;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Sales Customer {" +
                "id=" + customerId +
                ", name='" + customerName + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}