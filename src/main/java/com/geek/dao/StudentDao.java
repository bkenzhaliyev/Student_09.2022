package com.geek.dao;

import com.geek.models.Gender;
import com.geek.models.Student;
import com.geek.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class StudentDao {
    public Student findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    public void save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Student> findAll() {
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }

    public List<Student> findStudent2Date(LocalDate date1, LocalDate date2) {
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createNamedQuery("Student.findByBirthdayBetween", Student.class).setParameter("bday1", date1).setParameter("bday2", date2).list();
        return students;
    }

    public List<Student> findStudentByGender(Gender gender) {
        List<Student> students = (List<Student>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createNamedQuery("Student.findByGender", Student.class).setParameter("gender", gender).list();
        return students;
    }
}
