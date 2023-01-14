package com.studyproj.banking.services.impl;

import com.studyproj.banking.entities.Account;
import com.studyproj.banking.exceptions.ExceptionMessage;
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
    void getsuccessGetAllAccounts() {
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

    @Test
    void getSuccessAccountById() {
        Account account = mock(Account.class);
        account.setBalance(Mockito.anyDouble());
        account.setAccountType(Mockito.anyInt());

        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(account));

        Assertions.assertDoesNotThrow(() -> accountService.getAccount(Mockito.anyLong()));
    }

    @Test
    void getSuccessWhenCreateANewAccount() {
        Account account = mock(Account.class);

        when(accountService.createAccount(account)).thenReturn(account);

        Assertions.assertDoesNotThrow(() -> accountService.createAccount(new Account()));
    }

    @Test
    void getSuccessWhenBlockAccount() {
        Account account = mock(Account.class);

        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(account));
        when(accountService.blockAccount(Mockito.anyLong())).thenReturn(account);

        Assertions.assertDoesNotThrow(() -> accountService.blockAccount(Mockito.anyLong()));
    }

    @Test
    void getAccountDoNotExistsWhenBlockAccount() {
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.empty());

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> accountService.blockAccount(Mockito.anyLong()), "Account not found");
    }

    @Test
    void getAccountAlreadyBlockedWhenBlockAccount() {
        Account account = new Account();
        account.setId(Mockito.anyLong());
        account.setBlocked(true);

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> accountService.blockAccount(Mockito.anyLong()), "Account already blocked");
    }

    @Test
    void getSuccessWhenUnblockAccount() {
        Account account = new Account();
        account.setId(Mockito.anyLong());
        account.setBlocked(true);

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertDoesNotThrow(() -> accountService.unblockAccount(account.getId()));
    }

    @Test
    void getAccountDoNotExistsWhenUnblockAccount() {
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.empty());

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> accountService.unblockAccount(Mockito.anyLong()), "Account not found");
    }

    @Test
    void getAccountAlreadyUnblockedWhenUnblockAccount() {
        Account account = new Account();
        account.setId(Mockito.anyLong());
        account.setBlocked(false);

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> accountService.unblockAccount(Mockito.anyLong()), "Account already unblocked");
    }

    @Test
    void getFalseWhenCheckBlockStatus() {
        Account account = new Account();
        account.setId(Mockito.anyLong());
        account.setBlocked(false);

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertFalse(accountService.getBlockedStatus(account.getId()));
    }

    @Test
    void getTrueWhenCheckBlockStatus() {
        Account account = new Account();
        account.setId(Mockito.anyLong());
        account.setBlocked(true);

        when(accountRepository.findById(account.getId())).thenReturn(java.util.Optional.of(account));

        Assertions.assertTrue(accountService.getBlockedStatus(account.getId()));
    }

    @Test
    void getAccountDoNotExistsWhenCheckBlockStatus() {
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.empty());

        Assertions.assertThrowsExactly(ExceptionMessage.class, () -> accountService.getBlockedStatus(Mockito.anyLong()), "Account not found");
    }
}