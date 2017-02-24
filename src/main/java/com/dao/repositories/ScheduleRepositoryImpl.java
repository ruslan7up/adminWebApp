package com.dao.repositories;

import com.core.domain.entities.Schedule;
import com.dao.ScheduleRepository;
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
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Schedule> getAllSchedules() {
        Query query = sessionFactory.openSession().createQuery("FROM Schedule");
        List<Schedule> result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public Schedule getScheduleByID(Long id) {
        Query query = sessionFactory.openSession().createQuery("FROM Schedule WHERE id=:id");
        query.setParameter("id", id);
        Schedule result = (Schedule) query.getSingleResult();
        return result;
    }

    @Override
    public Schedule getScheduleByName(String name) {
        Query query = sessionFactory.openSession().createQuery("FROM Schedule WHERE name LIKE :ScheduleName");
        query.setParameter("ScheduleName", name);
        Schedule result = null;
        try {
          result = (Schedule) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("EXCEPTION "+e.getMessage());
        }
        return result;
    }

    @Override
    public void removeSchedule(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM Schedule WHERE id=:id");
            query.setParameter("id",id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Override
    public void addSchedule(Schedule schedule) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try
        {
            transaction.begin();
            session.save(schedule);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(schedule);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
    }
}
