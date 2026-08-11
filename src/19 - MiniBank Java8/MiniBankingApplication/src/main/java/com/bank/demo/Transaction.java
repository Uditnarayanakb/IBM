package com.bank.demo;

import java.time.LocalDate;

public class Transaction {

    private int amount;
    private LocalDate date;

    public Transaction(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
