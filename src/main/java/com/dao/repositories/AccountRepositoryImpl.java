package com.dao.repositories;

import com.core.domain.entities.Account;
import com.dao.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 * Created by Account on 13.01.2017.
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private Session session;

    @Autowired
    public AccountRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }


    @Override
    public Account getAccountByLogin(String login) {
        Query query = session.createQuery("FROM Account WHERE login=:login");
        query.setParameter("login", login);
        Account account = null;
        account = (Account) query.getSingleResult();
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        Transaction transaction = session.getTransaction();
        try
        {
            transaction.begin();
            session.merge(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("error");
        }
    }
}
