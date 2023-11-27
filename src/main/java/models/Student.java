package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.UUID;

@Entity
public class Student {
    @Id
    @Column(name = "ulearn_id")
    private UUID ulearnId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column(name = "student_group")
    private String group;

    public UUID getUlearnId() {
        return ulearnId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException();
        }
        this.surname = surname;
    }

    public void setUlearnId(UUID ulearnId) {
        if (ulearnId == null) {
            throw new IllegalArgumentException();
        }
        this.ulearnId = ulearnId;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public void setGroup(String group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        this.group = group;
    }
}