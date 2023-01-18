package org.example.hw1.model;

public class House {
    private final Door door;
    private final Window window;
    private final Wall wall;

    public House(Door door, Window window, Wall wall) {
        this.door = door;
        this.window = window;
        this.wall = wall;
    }

    @Override
    public String toString() {
        return "House{" +
                "door=" + door +
                ", window=" + window +
                ", wall=" + wall +
                '}';
    }
}
