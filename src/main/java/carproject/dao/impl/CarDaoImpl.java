package carproject.dao.impl;

import carproject.dao.CarDao;
import carproject.model.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.QueryHints;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public Long add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car.getCarId();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new HibernateException("Can't add a car to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Car findById(Long id) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("select distinct c from Car c "
                    + "left join fetch c.carDoors where c.id = :id");
            query.setParameter("id", id);
            query.setHint(QueryHints.PASS_DISTINCT_THROUGH, false);
            Car car = (Car) query.uniqueResult();
            Query query2 = session.createQuery("select distinct c from Car c "
                    + "left join fetch c.carWheels where c in :car");
            query2.setParameter("car", car);
            query2.setHint(QueryHints.PASS_DISTINCT_THROUGH, false);
            car = (Car) query2.uniqueResult();
            return car;
        } catch (HibernateException e) {
            throw new HibernateException("Can't find a car by id", e);
        }
    }
}
