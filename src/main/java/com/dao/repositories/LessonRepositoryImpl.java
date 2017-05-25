package com.dao.repositories;

import com.core.domain.entities.Substitution;
import com.core.services.LessonService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ruslan on 24.05.2017.
 */
@Repository
public class LessonRepositoryImpl implements LessonService {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Substitution> getSubstitutions(Date date) {
        Session session = factory.openSession();
        Date endDate = new Date(date.getTime()+ TimeUnit.HOURS.toMillis(7));

        List<Substitution> resList = null;
        try {
            Criteria criteria = session.createCriteria(Substitution.class);

            Conjunction conjunction = Restrictions.conjunction();
            conjunction.add(Restrictions.ge("date", date));
            conjunction.add(Restrictions.lt("date", endDate));
            criteria.add(conjunction);
            resList = (List<Substitution>) criteria.list();
        } catch (Exception e) {
        }
        session.close();
        return resList;
    }

    @Override
    public void deleteSubstitution(long id) {
        Session session = factory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("DELETE FROM Substitution WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void addSubstitution(Substitution substitution) {
        Session session = factory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(substitution);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("REPO ERR "+e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
