package org.bank.mockitobankdemo;

public interface BankRepository {

    BankAccount findByAccountNumber(
            String accountNumber);

    void save(BankAccount account);
}


