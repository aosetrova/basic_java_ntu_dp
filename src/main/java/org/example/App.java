package org.example;

import org.example.model.human.Human;
import org.example.model.human.Sex;
import org.example.model.human.Student;
import org.example.model.unit.Department;
import org.example.model.unit.Faculty;
import org.example.model.unit.Group;
import org.example.model.unit.University;
import org.example.utils.JsonManager;

import java.io.IOException;

/**
 * Lab work 3
 * Created by Anhelina Osetrova
 */
public class App {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        Human rector = new Human("Ivan", "Petrenko", "Ivanovych", Sex.MALE);
        University university = new University("Kyiv University", rector);

        Human facultyHead = new Human("Maria", "Shevchenko", "Olehivna", Sex.FEMALE);
        Faculty faculty = new Faculty("Computer Science", facultyHead);
        university.addFaculty(faculty);

        Human departmentHead = new Human("Oleh", "Koval", "Ivanovych", Sex.MALE);
        Department department = new Department("Software Engineering", departmentHead);
        faculty.addDepartment(department);

        Human groupHead = new Human("Anna", "Tkach", "Serhiivna", Sex.FEMALE);
        Group group = new Group("SE-21", groupHead);
        department.addGroup(group);

        Student student1 = new Student("Andriy", "Pavlenko", "Ihorovych", Sex.MALE);
        Student student2 = new Student("Oksana", "Mazur", "Petrovna", Sex.FEMALE);
        group.addStudent(student1);
        group.addStudent(student2);

        try {
            JsonManager.saveToJsonFile(university, "university.json");
            University loadedUniversity = JsonManager.loadFromJsonFile("university.json");
            System.out.println("University successfully saved and loaded from JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
