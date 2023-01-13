package com.studyproj.banking.services;
import com.studyproj.banking.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction deposit(Transaction transaction);

    Transaction withdraw(Transaction transaction);

    List<Transaction> statement(long id);
}
