package org.example.model.unit;

import org.example.model.human.Human;
import org.example.model.human.Student;

import java.util.ArrayList;
import java.util.List;


public
// Клас Група
class Group extends Unit {
    private List<Student> students = new ArrayList<>();

    public Group(String name, Human head) {
        super(name, head);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group: " + name + ", Head: " + head + ", Students: " + students;
    }
}
