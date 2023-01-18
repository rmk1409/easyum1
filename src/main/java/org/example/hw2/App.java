package org.example.hw2;

import org.example.hw2.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 */
@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
            Employee employee = context.getBean(Employee.class);
            employee.aboutMe();
        }
    }
}
