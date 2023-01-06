package org.example;

import org.example.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml")) {
            Employee employee = context.getBean(Employee.class);
            employee.aboutMe();
        }
    }
}
