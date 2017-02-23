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


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public News getNewsById(long id) {
        Query query = sessionFactory.openSession().createQuery("FROM News WHERE id=:id");
        query.setParameter("id",id);
        News news = null;
        try {
            news = (News) query.getSingleResult();
        } catch (Exception e) {

        }
        return news;
    }

    @Override
    public List<News> getNewsByPageNumber(int page) {
        Query query = sessionFactory.openSession().createQuery("FROM News ORDER BY id DESC").setFirstResult((page-1)*10).setMaxResults(10);
        List<News> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Integer getNumberOfPages() {
        Long count = ((long) sessionFactory.openSession().createQuery("SELECT count(*) from News").uniqueResult());
        return (int) Math.ceil((double) count.intValue()/10);
    }

    @Override
    public void addNews(News news) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(news);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void removeNews(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM News WHERE id=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("ERROR NEWS "+e.getMessage());
            transaction.rollback();
        }
    }
}
