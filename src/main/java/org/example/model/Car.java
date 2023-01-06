package org.example.model;

public class Car {
    private int speed;

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
