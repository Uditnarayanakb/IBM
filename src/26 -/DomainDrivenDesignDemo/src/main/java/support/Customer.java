package com.example.support;

public class Customer {

    private Long customerId;
    private String customerName;
    private String issueType;
    private String supportLevel;

    public Customer(Long customerId,
                    String customerName,
                    String issueType,
                    String supportLevel) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.issueType = issueType;
        this.supportLevel = supportLevel;
    }

    @Override
    public String toString() {
        return "Support Customer {" +
                "id=" + customerId +
                ", name='" + customerName + '\'' +
                ", issueType='" + issueType + '\'' +
                ", supportLevel='" + supportLevel + '\'' +
                '}';
    }
}