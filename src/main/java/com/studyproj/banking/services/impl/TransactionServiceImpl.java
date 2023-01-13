package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.entities.Transaction;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.AccountRepository;
import com.studyproj.banking.repositories.TransactionRepository;
import com.studyproj.banking.services.AccountService;
import com.studyproj.banking.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final AccountService accountService;

    private static final String ERROR = "Account does not exist.";

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    public Transaction deposit(Transaction transaction) {
        Account account = accountRepository.getReferenceById(transaction.getAccount().getId());
        if (isNull(accountService.getAccount(account.getId()))) {
            throw new ExceptionMessage(ERROR);
        }
        transaction.setOldBalance(account.getBalance());
        account.setBalance(account.getBalance() + transaction.getAmount());
        transaction.setNewBalance(account.getBalance());
        transaction.setTransactionType("Deposit");
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction withdraw(Transaction transaction) {
        Account account = accountRepository.getReferenceById(transaction.getAccount().getId());
        if (isNull(accountService.getAccount(account.getId()))) {
            throw new ExceptionMessage(ERROR);
        }
        if(account.getBalance() < transaction.getAmount()) {
            throw new ExceptionMessage("Insufficient funds.");
        }
        transaction.setOldBalance(account.getBalance());
        account.setBalance(account.getBalance() - transaction.getAmount());
        transaction.setNewBalance(account.getBalance());
        transaction.setTransactionType("withdraw");
        transactionRepository.save(transaction);
        return transaction;
    }

    public List<Transaction> statement(long id) {
        Account account = accountRepository.getReferenceById(id);
        if (isNull(accountService.getAccount(account.getId()))) {
            throw new ExceptionMessage(ERROR);
        }
        return transactionRepository.streamTransactionsByAccount(account);
    }
}
