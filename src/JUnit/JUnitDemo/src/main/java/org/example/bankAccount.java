package org.example;


public class bankAccount {

    private String accountNumber;
    private double balance;

    public bankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }
}
