package com.studyproj.banking.services;
import com.studyproj.banking.entities.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account getAccount(long id);

    Account createAccount(Account account);

    String blockAccount(long id);

    String unblockAccount(long id);

    String getBlockedStatus(long id);
}
