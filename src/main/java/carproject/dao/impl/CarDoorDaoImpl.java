package carproject.dao.impl;

import carproject.dao.CarDoorDao;
import carproject.model.CarDoor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoorDaoImpl implements CarDoorDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long add(CarDoor door) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(door);
            transaction.commit();
            return door.getDoorId();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new HibernateException("Can't add a door to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public CarDoor findById(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(CarDoor.class, id);
        } catch (HibernateException e) {
            throw new HibernateException("Can't find a door by id", e);
        }
    }
}
