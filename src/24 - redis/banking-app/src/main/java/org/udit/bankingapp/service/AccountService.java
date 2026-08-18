package org.udit.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.udit.bankingapp.entity.Account;
import org.udit.bankingapp.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Cacheable(value = "accounts", key = "#accountId")
    public Account getAccountDetails(Long accountId) {

        System.out.println("Fetching from DB...");

        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @CachePut(value = "accounts", key = "#account.id")
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @CacheEvict(value = "accounts", key = "#accountId")
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}