package com.geek.dao;

import com.geek.models.Gender;
import com.geek.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class GenderDao {

     public Gender findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Gender.class, id);
    }

    public Gender findByGenderTitle(String title) {
        return (Gender) HibernateSessionFactoryUtil.getSessionFactory().openSession().createNamedQuery("Gender.findByTitle", Gender.class).setParameter("gender", title).getSingleResult();
    }

    public void save(Gender gender) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(gender);
        transaction.commit();
        session.close();
    }

    public void update(Gender gender) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(gender);
        transaction.commit();
        session.close();
    }

    public void delete(Gender gender) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(gender);
        transaction.commit();
        session.close();
    }

    public List<Gender> findAll() {
        List<Gender> genders = (List<Gender>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Gender").list();
        return genders;
    }
}
