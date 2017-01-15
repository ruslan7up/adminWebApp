package com.dao.repositories;

import com.core.domain.entities.Class;
import com.dao.ClassRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ruslan on 15.01.2017.
 */
@Repository
public class ClassRepositoryImpl implements ClassRepository {

    private Session session;

    @Autowired
    public ClassRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }


    @Override
    public void addClass(Class clazz) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(clazz);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void removeClass(Long id) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM Class WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
