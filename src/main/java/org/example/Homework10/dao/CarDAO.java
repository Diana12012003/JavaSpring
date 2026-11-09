package org.example.Homework10.dao;
import org.example.Homework10.models.Car;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
    public class CarDAO {
        @PersistenceContext
        private EntityManager entityManager;


        public void save(Car car) {
            entityManager.persist(car);

        }

        public List<Car> findAll() {
            return entityManager.createQuery("select c from Car c", Car.class).getResultList();

        }

        public Car findOne(int id) {
            return entityManager.find(Car.class, id);
        }

    public void delete(int id) {
        Car car = findOne(id);
        if (car != null) {
            entityManager.remove(car);
        }
    }

        public List<Car> findByProducer(String producer) {
            return entityManager.createQuery("select c from Car c where c.producer = :p",Car.class)
                    .setParameter("p", producer)
                    .getResultList();
        }

        public List<Car> findByPower(int power) {
            return entityManager.createQuery("select c from Car c where c.power = :p", Car.class)
                    .setParameter("p", power)
                    .getResultList();
        }
    }

