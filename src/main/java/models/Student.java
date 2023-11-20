package models;

import java.util.UUID;

public class Student {
    private UUID ulearnId;
    private String name;
    private String surname;
    private String email;
    private String group;
    private StudentPerformance studentPerformance;
    private UUID studentPerformanceId;

    public Student() {

    }

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

    public StudentPerformance getStudentPerformance() {
        return studentPerformance;
    }

    public UUID getStudentPerformanceId() {
        return studentPerformanceId;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setSurname(String surname) {
        if (surname != null && !surname.isEmpty()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setUlearnId(UUID ulearnId) {
        if (ulearnId != null) {
            this.ulearnId = ulearnId;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setGroup(String group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        this.group = group;
    }

    public void setStudentPerformance(StudentPerformance studentPerformance) {
        this.studentPerformance = studentPerformance;
    }

    public void setStudentPerformanceId(UUID studentPerformanceId) {
        this.studentPerformanceId = studentPerformanceId;
    }
}