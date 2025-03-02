package org.example.controller;

import org.example.model.human.Sex;
import org.example.model.human.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
