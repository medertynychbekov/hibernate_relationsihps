package org.example.service.impl;

import org.example.config.HibernateConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public void save(User user) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User updateById(Long id, User newUser) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
