package org.example.hw4.dao;

import org.example.hw4.entity.Person;

import java.util.List;

public interface PersonDao {
    Person get(Long id);

    List<Person> getAll();

    Person save(Person person);
    Person update(Person person);

    void delete(Long id);
}
