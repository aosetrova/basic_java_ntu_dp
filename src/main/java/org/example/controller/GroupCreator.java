package org.example.controller;

import org.example.model.human.Human;
import org.example.model.unit.Group;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
