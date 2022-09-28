package com.geek.models;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = "Student.findByName",
                query = "SELECT s FROM Student s Where s.name=:name"),
        @NamedQuery(name = "Student.findByGender",
                query = "SELECT s FROM Student s Where s.gender=:gender Order by birthday"),
        @NamedQuery(name = "Student.findByBirthdayBetween",
                query = "SELECT s FROM Student s Where s.birthday between :bday1 and :bday2 Order by birthday")
})

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @Column(name ="id")
    private long id;

    @Column(name ="firstName", nullable = false, length = 35)
    private String firstName;

    @Column(name ="name", nullable = false, length = 35)
    private String name;

    @Column(name ="middleName", nullable = false, length = 35)
    private String middleName;

    @Column(name ="birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne
    private Gender gender;

    public Student(String firstName, String name, String middleName, LocalDate birthday, Gender gender) {
        this.firstName = firstName;
        this.name = name;
        this.middleName = middleName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
