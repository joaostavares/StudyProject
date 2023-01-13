package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AccountServiceImplTests {
    private AccountServiceImpl accountService;

    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        accountService = new AccountServiceImpl(accountRepository);

    }

    @Test
    void getSuccessWhenCreateANewAccount() {
        Account account = new Account();
        account.setBalance(100.0);
        account.setAccountType(1);

        when(accountService.createAccount(account)).thenReturn(account);

        Assertions.assertDoesNotThrow(() -> accountService.createAccount(new Account()));
    }
    @Test
    void getAllAccounts() {
        Account account1 = mock(Account.class);
        account1.setBalance(Mockito.anyDouble());
        account1.setAccountType(Mockito.anyInt());

        Account account2 = mock(Account.class);
        account2.setBalance(Mockito.anyDouble());
        account2.setAccountType(Mockito.anyInt());

        when(accountService.getAll()).thenReturn(List.of(account1, account2));

        Assertions.assertDoesNotThrow(() -> accountService.getAll());
        Assertions.assertNotEquals(0, accountService.getAll().size());
    }

}
