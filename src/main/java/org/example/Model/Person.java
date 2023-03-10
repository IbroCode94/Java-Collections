package org.example.Model;

import enums.Role;

public class Person {

    private String name;
    private int age;

    private Role position;

    public Person() {
    }

    public Person(String name, int age, Role position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getPosition() {
        return position;
    }

    public void setPosition(Role position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
