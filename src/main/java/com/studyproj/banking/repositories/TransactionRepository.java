package com.studyproj.banking.repositories;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> streamTransactionsByAccount(Account account);
}
