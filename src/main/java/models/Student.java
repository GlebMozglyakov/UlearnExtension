package models;

import java.util.List;
import java.util.UUID;

class Student {
    private final UUID id;
    private final String name;
    private final String surname;
    private final UUID ulearnId;
    private final String email;
    private final String group;
    private final StudentPerformance studentPerformance;
    private final UUID studentPerformanceId;

    public Student(UUID id,
                   String name,
                   String surname,
                   UUID ulearnId,
                   String email,
                   String group,
                   StudentPerformance studentPerformance,
                   UUID studentPerformanceId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ulearnId = ulearnId;
        this.email = email;
        this.group = group;
        this.studentPerformance = studentPerformance;
        this.studentPerformanceId = studentPerformanceId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UUID getUlearnId() {
        return ulearnId;
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
}