package org.example.model.human;

// Студент (успадковується від Human)
public class Student extends Human {
    public Student(String firstName, String lastName, String middleName, Sex sex) {
        super(firstName, lastName, middleName, sex);
    }
}