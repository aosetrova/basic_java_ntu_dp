package org.example.model.unit;

import org.example.model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Department extends Unit {
    private List<Group> groups = new ArrayList<>();

    public Department(String name, Human head) {
        super(name, head);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
