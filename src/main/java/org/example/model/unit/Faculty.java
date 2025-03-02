package org.example.model.unit;

import org.example.model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Unit {
    private List<Department> departments = new ArrayList<>();

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}
