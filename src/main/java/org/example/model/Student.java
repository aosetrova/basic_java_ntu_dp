package org.example.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String gradebookNumber;

    public Student(int id, String lastName, String firstName, String middleName, LocalDate birthDate, String gradebookNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gradebookNumber = gradebookNumber;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " - " + birthDate;
    }
}

