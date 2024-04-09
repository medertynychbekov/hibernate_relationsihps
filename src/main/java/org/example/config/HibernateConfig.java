package org.example.config;

import org.example.model.Passport;
import org.example.model.User;
import org.example.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();
    }
}
