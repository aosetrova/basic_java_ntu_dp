package org.example.model.human;

// Базовий клас для людини
public class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + sex + ")";
    }
}