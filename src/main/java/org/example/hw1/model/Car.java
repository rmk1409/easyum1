package org.example.hw1.model;

public class Car {
    private final int speed;

    public Car(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }
}
