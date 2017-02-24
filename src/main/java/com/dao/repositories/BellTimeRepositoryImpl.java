package com.dao.repositories;

import com.core.domain.entities.BellTime;
import com.dao.BellTimeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
@Repository
public class BellTimeRepositoryImpl implements BellTimeRepository {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<BellTime> getBellTime() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM BellTime ORDER BY id");
        List<BellTime> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void updateBellTime(List<BellTime> bellTime) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            for (BellTime tmp:bellTime) {
                session.merge(tmp);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}