package com.dao.repositories;

import com.core.domain.entities.Class;
import com.dao.ClassRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ruslan on 15.01.2017.
 */
@Repository
public class ClassRepositoryImpl implements ClassRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addClass(List<List<Class>> clazz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            for (List<Class> claz:clazz) {
                for (Class claz2: claz) {
                    session.save(claz2);
                }
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeClass(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM Class WHERE schedule_id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Class Exception "+e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
