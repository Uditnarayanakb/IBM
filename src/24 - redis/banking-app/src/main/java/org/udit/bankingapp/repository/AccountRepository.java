package org.udit.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.udit.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}