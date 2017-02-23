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

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Account getAccountByLogin(String login) {
        Query query = sessionFactory.openSession().createQuery("FROM Account WHERE login=:login");
        query.setParameter("login", login);
        Account account = null;
        try {
            account = (Account) query.getSingleResult();
        } catch (Exception e) {

        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try
        {
            transaction.begin();
            session.merge(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
