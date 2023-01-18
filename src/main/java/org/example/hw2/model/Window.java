package org.example.hw2.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Window {
    private final int width;
    private final int height;

    public Window(@Value("${window.width}") int width, @Value("${window.height}") int height) {
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
