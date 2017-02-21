package com.dao.repositories;

import com.core.domain.entities.Link;
import com.dao.NewsLinksRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;

import java.util.List;

/**
 * Created by ruslan on 05.02.2017.
 */
@Repository
public class NewsLinksRepositoryImpl implements NewsLinksRepository {

    private Session session;

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
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM Link WHERE news_id=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
