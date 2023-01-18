package org.example.hw2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private final int speed;

    public Car(@Value("${car.speed}") int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }
}
