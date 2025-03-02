package org.example.controller;

import org.example.model.human.Human;
import org.example.model.unit.University;

public class UniversityCreator {
    public static University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
