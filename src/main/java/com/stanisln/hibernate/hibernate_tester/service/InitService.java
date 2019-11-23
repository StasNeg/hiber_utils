package com.stanisln.hibernate.hibernate_tester.service;

import com.stanisln.hibernate.hibernate_tester.dao.RoleDao;
import com.stanisln.hibernate.hibernate_tester.dao.UserDao;
import com.stanisln.hibernate.hibernate_tester.model.Role;
import com.stanisln.hibernate.hibernate_tester.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class InitService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public void init() {
        User user = new User("stas@ua.fm", "Stas", "Nizhn", "12");
        Role admin = new Role("Admin");
        Role userRole = new Role("User");
        Role testRole = new Role("tester");
        User user1 = new User("stas@ua1.fm", "Stas", "12");
        userDao.save(user);
        user.setEmail("stas12@12.com");
        userDao.save(user);
        userDao.save(user);
        roleDao.save(admin);
        roleDao.save(userRole);
        try {
            userDao.save(user1);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
//        testRole.setId(1L);
        user.setRoles(Arrays.asList(admin, userRole, testRole));
        userDao.save(user);
//        user1.setId(null);
        user1.setRoles(Arrays.asList(admin, userRole, testRole));
        userDao.save(user1);
        roleDao.save(testRole);
        userDao.remove(100000L);
        testRole.setUsers(Arrays.asList(user1));
    }
}
