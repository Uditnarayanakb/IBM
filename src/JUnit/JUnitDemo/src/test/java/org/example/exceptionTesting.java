package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class exceptionTesting {
    @Test
    void testWithdrawInsufficientFunds() {
        bankAccount account = new bankAccount("123", 100.0);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient balance", ex.getMessage());
    }

    @Test
    void testWithdrawFail() {

        bankAccount account =
                new bankAccount("123", 1000.0);

        account.withdraw(200);

        assertEquals(900.0, account.getBalance());
    }
}

