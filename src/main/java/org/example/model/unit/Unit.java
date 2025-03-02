package org.example.model.unit;

import org.example.model.human.Human;

// Абстрактний клас для структурних підрозділів
abstract class Unit {
    protected String name;
    protected Human head;

    public Unit(String name, Human head) {
        this.name = name;
        this.head = head;
    }
}
