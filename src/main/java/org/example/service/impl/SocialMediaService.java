package org.example.service.impl;

import org.example.config.HibernateConfig;
import org.example.model.SocialMedia;
import org.example.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class SocialMediaService {

    public void save(SocialMedia socialMedia) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(socialMedia);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public SocialMedia findById(Long id) {
        SocialMedia socialMedia = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            socialMedia = session.get(SocialMedia.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return socialMedia;
    }
}
