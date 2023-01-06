package org.example.model;

public class Door {
    private final int width;
    private final int height;

    public Door(int width, int height) {
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
