package org.example.model.unit;

import org.example.model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class University extends Unit {
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name, Human head) {
        super(name, head);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}
