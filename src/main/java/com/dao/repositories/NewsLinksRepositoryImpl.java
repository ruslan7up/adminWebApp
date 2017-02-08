package com.dao.repositories;

import com.core.domain.entities.Link;
import com.dao.NewsLinksRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */

@Repository
public class NewsLinksRepositoryImpl implements NewsLinksRepository {

    Session session;

    @Autowired
    public NewsLinksRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }

    @Override
    public void addLink(List<Link> link) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            for (Link tmp:link) {
                session.save(tmp);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void removeLink(Long id) {
        Transaction transtacion = session.beginTransaction();
        try {
            transtacion.begin();
            Query query = session.createQuery("DELETE FROM Link WHERE news_id=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            transtacion.commit();
        } catch (Exception e) {
            transtacion.rollback();
        }
    }
}
