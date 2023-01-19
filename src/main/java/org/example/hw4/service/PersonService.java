package org.example.hw4.service;

import org.example.hw4.dao.PersonDao;
import org.example.hw4.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    private final PersonDao dao;

    public PersonService(PersonDao dao) {
        this.dao = dao;
    }

    public Person get(Long id) {
        return dao.get(id);
    }

    public List<Person> getAll() {
        return dao.getAll();
    }

    @Transactional
    public Person save(Person person) {
        return dao.save(person);
    }

    @Transactional
    public Person update(Person person) {
        Person found = dao.get(person.getId());
        if (Objects.isNull(found)) {
            throw new IllegalArgumentException("Not found with id: " + person.getId());
        }

        found.setName(person.getName());
        return dao.update(found);
    }

    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }
}
