package org.bank.mockitobankdemo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    @Test
    void testDeposit() {

        BankRepository mockRepo =
                mock(BankRepository.class);

        BankAccount account =
                new BankAccount("123", 500);

        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);

        BankService service =
                new BankService(mockRepo);

        service.deposit("123", 200);

        assertEquals(
                700,
                account.getBalance());

        verify(mockRepo)
                .save(account);
    }
    @Test
    void testWithdrawSuccess() {

        BankRepository mockRepo =
                mock(BankRepository.class);

        BankAccount account =
                new BankAccount("123",500);

        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);

        BankService service =
                new BankService(mockRepo);

        service.withdraw("123",200);

        assertEquals(
                300,
                account.getBalance());

        verify(mockRepo)
                .save(account);
    }
    @Test
    void testWithdrawInsufficientFunds() {

        BankRepository mockRepo =
                mock(BankRepository.class);

        BankAccount account =
                new BankAccount("123",100);

        when(mockRepo.findByAccountNumber("123"))
                .thenReturn(account);

        BankService service =
                new BankService(mockRepo);

        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.withdraw("123",200)
        );

        assertEquals(
                "Insufficient funds",
                ex.getMessage());

        verify(mockRepo, never())
                .save(account);
    }
}