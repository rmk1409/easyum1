package org.example.model;

public class Employee {
    private final String name;
    private final Car car;
    private final House house;
    private final Pet pet;

    public Employee(Car car, House house, Pet pet, String name) {
        this.car = car;
        this.house = house;
        this.pet = pet;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ",\n name='" + name + '\'' +
                ",\n car=" + car +
                ",\n house=" + house +
                ",\n pet=" + pet +
                "\n}";
    }

    public void aboutMe() {
        System.out.println(this);
    }
}
