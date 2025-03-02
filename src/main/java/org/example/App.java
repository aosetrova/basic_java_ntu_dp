package org.example;

import org.example.controller.*;
import org.example.model.human.Human;
import org.example.model.human.Sex;
import org.example.model.human.Student;
import org.example.model.unit.Department;
import org.example.model.unit.Faculty;
import org.example.model.unit.Group;
import org.example.model.unit.University;

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
        University university = UniversityCreator.createUniversity("Kyiv University", rector);

        Human facultyHead = new Human("Maria", "Shevchenko", "Olehivna", Sex.FEMALE);
        Faculty faculty = FacultyCreator.createFaculty("Computer Science", facultyHead);
        university.addFaculty(faculty);

        Human departmentHead = new Human("Oleh", "Koval", "Ivanovych", Sex.MALE);
        Department department = DepartmentCreator.createDepartment("Software Engineering", departmentHead);
        faculty.addDepartment(department);

        Human groupHead = new Human("Anna", "Tkach", "Serhiivna", Sex.FEMALE);
        Group group = GroupCreator.createGroup("SE-21", groupHead);
        department.addGroup(group);

        Student student1 = StudentCreator.createStudent("Andriy", "Pavlenko", "Ihorovych", Sex.MALE);
        Student student2 = StudentCreator.createStudent("Oksana", "Mazur", "Petrovna", Sex.FEMALE);
        group.addStudent(student1);
        group.addStudent(student2);

        System.out.println("University created successfully!");
    }
}
