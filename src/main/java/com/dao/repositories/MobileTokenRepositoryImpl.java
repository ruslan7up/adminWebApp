package com.dao.repositories;

import com.core.domain.entities.MobileToken;
import com.dao.MobileTokenRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ruslan on 30.01.2017.
 */
@Repository
public class MobileTokenRepositoryImpl implements MobileTokenRepository {

    private Session session;

    @Autowired
    public MobileTokenRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }

    @Override
    public void addNewToken(MobileToken token) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(token);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public List<MobileToken> getAllTokens() {
        Query query = session.createQuery("FROM MobileToken");
        List<MobileToken> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }
}
