package com.geek.models;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Gender.findByTitle",
                query = "SELECT g FROM Gender g Where g.gender=:gender")
})
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "gender", nullable = false, length = 15)
    private String gender;

    public Gender() {
    }

    public Gender(String gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
