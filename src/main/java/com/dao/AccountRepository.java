package com.dao;

import com.core.domain.entities.Account;

/**
 * Created by Account on 13.01.2017.
 */

public interface AccountRepository {
    Account getAccountByLogin(String login);
    void updateAccount(Account account);
}
