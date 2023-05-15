package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.exceptions.ExceptionMessage;
import com.studyproj.banking.repositories.AccountRepository;
import com.studyproj.banking.services.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account getAccount(long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    public Account createAccount(Account account) {
        account.setCreationDate(LocalDate.now());
        account.setBlocked(false);
        accountRepository.save(account);
        return account;
    }

    public String blockAccount(long id) {
        Account account = getAccount(id);
        if (isNull(account)) {
            throw new ExceptionMessage("Account not found");
        }
        if (account.isBlocked()) {
            throw new ExceptionMessage("Account already blocked");
        }
        account.setBlocked(true);
        accountRepository.save(account);
        return "Account " + account.getId() + " is now blocked";
    }

    public String unblockAccount(long id) {
        Account account = getAccount(id);
        if (isNull(account)) {
            throw new ExceptionMessage("Account not found");
        }
        if (!account.isBlocked()) {
            throw new ExceptionMessage("Account already unblocked");
        }
        account.setBlocked(false);
        accountRepository.save(account);
        return "Account " + account.getId() + " is now unblocked";
    }

    public String getBlockedStatus(long id) {
        Account account = getAccount(id);
        if (isNull(account)) {
            throw new ExceptionMessage("The account does not exist.");
        }
        return account.isBlocked() ? "Account " + account.getId() + " is blocked" : "Account " + account.getId() + " is unblocked";
    }
}

