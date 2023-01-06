package org.example.model;

public class Wall {
    private final String material;

    public Wall(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "material='" + material + '\'' +
                '}';
    }
}
