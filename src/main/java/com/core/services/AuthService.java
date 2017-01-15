package com.core.services;

import com.core.domain.entities.Account;

/**
 * Created by ruslan on 14.01.2017.
 */
public interface AuthService {
    Account getAccountByLogin(String login);
    void updateAccount(Account account);
}
