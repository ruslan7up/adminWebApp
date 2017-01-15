package com.dao.repositories;

import com.core.domain.entities.DayOfWeek;
import com.dao.DayOfWeekRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Account on 13.01.2017.
 */
@Repository
public class DayOfWeekRepositoryImpl implements DayOfWeekRepository {

    private Session session;

    public DayOfWeekRepositoryImpl(SessionFactory session) {
        this.session = session.openSession();
    }

    @Override
    public void addDayOfWeek(DayOfWeek dayOfWeek) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(dayOfWeek);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void removeDayOfWeek(Long id) {
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM DayOfWeek WHERE id=:id");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
