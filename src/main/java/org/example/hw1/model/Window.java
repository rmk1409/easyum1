package org.example.hw1.model;

public class Window {
    private final int width;
    private final int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Window{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
