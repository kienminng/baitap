package com.example.demo2.DAO;

import com.example.demo2.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarDAO {
    @Autowired
    EntityManager entityManager;

    public List<Car> getAll() {
        String sql = "Select c from Car c";
        List<Car> cars = entityManager.createQuery(sql,Car.class).getResultList();
        return cars;
    }

    public void save(Car car) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(car);
        txn.commit();
    }

    public void delete(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(car);
        transaction.commit();
    }

    public void edit(Car car) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(car);
        transaction.begin();
    }

    public Car findById(int id) {
        String sql = "select c from Car c where c.Id =" + id;
        Car car = (Car) entityManager.createQuery(sql);
        return car;
    }
}
