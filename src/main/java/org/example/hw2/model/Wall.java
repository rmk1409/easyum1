package org.example.hw2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wall {
    private final String material;

    public Wall(@Value("${wall.material}") String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "material='" + material + '\'' +
                '}';
    }
}
