package com.core.services.impl;

import com.core.domain.entities.Account;
import com.core.services.AuthService;
import com.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ruslan on 14.01.2017.
 */
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    AccountRepository repository;

    @Override
    public Account getAccountByLogin(String login) {
        return  repository.getAccountByLogin(login);
    }

    @Override
    public void updateAccount(Account account) {

    }
}
