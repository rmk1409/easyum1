package org.example.hw2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Door {
    private final int width;
    private final int height;

    public Door(@Value("${door.width}") int width, @Value("${door.height}") int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Door{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
