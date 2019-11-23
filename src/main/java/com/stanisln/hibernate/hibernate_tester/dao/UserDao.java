package com.stanisln.hibernate.hibernate_tester.dao;

import com.stanisln.hibernate.hibernate_tester.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public User find(long id) {
        return em.find(User.class, id);
    }

    public User save(User user) {
        em.unwrap(Session.class).saveOrUpdate(user);
        return user;
    }

    public void remove(long id) {
        em.unwrap(Session.class).remove(find(id));
    }
}
