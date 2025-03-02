package org.example.controller;

import org.example.model.human.Human;
import org.example.model.unit.Department;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
