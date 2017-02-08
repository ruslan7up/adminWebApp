package com.dao.repositories;

import com.core.domain.entities.News;
import com.dao.NewsRepository;
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
public class NewsRepositoryImpl implements NewsRepository {

    private Session session;

    @Autowired
    public NewsRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }

    @Override
    public List<News> getNewsByPageNumber(int page) {
        Query query = session.createQuery("FROM News ORDER BY id DESC").setFirstResult((page-1)*10).setMaxResults(10*page);
        List<News> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public Integer getNumberOfPages() {
        Long count = ((long) session.createQuery("SELECT count(*) from News").uniqueResult());
        return (int) Math.ceil((double) count.intValue()/10);
    }

    @Override
    public void addNews(News news) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(news);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public void removeNews(Long id) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM News WHERE id=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException();
        }
    }
}
