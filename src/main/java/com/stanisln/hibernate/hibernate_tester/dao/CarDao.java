package com.stanisln.hibernate.hibernate_tester.dao;

import com.stanisln.hibernate.hibernate_tester.model.Car;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarDao {

    @PersistenceContext
    private EntityManager em;

    public Car save(Car car) {
        em.unwrap(Session.class).saveOrUpdate(car);
        return car;
    }

    public Car find(long id) {
        return em.find(Car.class, id);
    }
}
