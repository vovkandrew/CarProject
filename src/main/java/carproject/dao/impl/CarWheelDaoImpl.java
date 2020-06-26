package carproject.dao.impl;

import carproject.dao.CarWheelDao;
import carproject.model.CarWheel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl implements CarWheelDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long add(CarWheel wheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(wheel);
            transaction.commit();
            return wheel.getWheelId();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new HibernateException("Can't add new wheel to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public CarWheel findById(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(CarWheel.class, id);
        } catch (HibernateException e) {
            throw new HibernateException("Can't find a wheel by id", e);
        }
    }
}
