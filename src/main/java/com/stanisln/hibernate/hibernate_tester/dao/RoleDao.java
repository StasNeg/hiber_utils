package com.stanisln.hibernate.hibernate_tester.dao;

import com.stanisln.hibernate.hibernate_tester.model.Role;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDao {

    @PersistenceContext
    private EntityManager em;


    public Role save(Role role) {
        em.unwrap(Session.class).saveOrUpdate(role);
        return role;
    }

    public Role find(long id) {
        return em.find(Role.class, id);
    }
}
