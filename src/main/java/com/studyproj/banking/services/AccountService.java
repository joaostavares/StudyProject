package com.studyproj.banking.services;
import com.studyproj.banking.entities.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account getAccount(long id);

    Account createAccount(Account account);

    Account blockAccount(long id);

    Account unblockAccount(long id);

    Boolean getBlockedStatus(long id);
}
