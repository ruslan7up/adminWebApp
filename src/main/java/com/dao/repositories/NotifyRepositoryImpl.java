package com.dao.repositories;

import com.core.domain.entities.Notify;
import com.dao.NotifyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Account on 13.01.2017.
 */
@Repository
public class NotifyRepositoryImpl implements NotifyRepository {

    private Session session;

    public NotifyRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }

    @Override
    public List<Notify> getAllNotifies() {
        Query query = session.createQuery("FROM Notify");
        List<Notify> result = null;
        try {
           result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public List<Notify> getLastNotifies() {
        Query query = session.createQuery("FROM Notify ORDER BY id DESC");
        query.setMaxResults(6);
        List<Notify> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public void addNotify(Notify notify) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(notify);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
