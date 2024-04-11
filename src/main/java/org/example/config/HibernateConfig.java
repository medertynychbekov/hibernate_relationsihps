package org.example.config;

import org.example.model.Passport;
import org.example.model.Pet;
import org.example.model.SocialMedia;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Pet.class)
                .addAnnotatedClass(SocialMedia.class)
                .buildSessionFactory();
    }
}
