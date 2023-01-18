package org.example.hw2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Employee {
    private final String name;

    private final Car car;
    private final House house;
    private final Pet pet;

    public Employee(Car car, House house, Pet pet, @Value("${employee.name}") String name) {
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

    @PostConstruct
    public void init() {
        System.out.println("P: init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("P: destroy");
    }
}
