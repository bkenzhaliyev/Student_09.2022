package com.geek.services;

import com.geek.dao.StudentDao;
import com.geek.models.Gender;
import com.geek.models.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    private StudentDao studentsDao = new StudentDao();

    public StudentService() {
    }

    public Student findStudent(long id) {
        return studentsDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentsDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentsDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentsDao.update(student);
    }

    public List<Student> findAllStudent() {
        return studentsDao.findAll();
    }

    public List<Student> findStudentByBirthdayBetween(LocalDate bdate1, LocalDate bdate2) {
        return studentsDao.findStudent2Date(bdate1, bdate2);
    }

    public List<Student> findStudentByGender(Gender gender) {
        return studentsDao.findStudentByGender(gender);
    }
}
