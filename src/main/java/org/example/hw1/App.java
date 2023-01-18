package org.example.hw1;

import org.example.hw1.model.Employee;
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
