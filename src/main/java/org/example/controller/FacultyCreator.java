package org.example.controller;

import org.example.model.human.Human;
import org.example.model.unit.Faculty;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
