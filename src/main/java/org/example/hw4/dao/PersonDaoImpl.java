package org.example.hw4.dao;

import org.example.hw4.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    private final SessionFactory sessionFactory;

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person get(Long id) {
        return sessionFactory
                .getCurrentSession()
                .get(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Person", Person.class)
                .getResultList();
    }

    @Override
    public Person save(Person person) {
        sessionFactory
                .getCurrentSession()
                .save(person);

        return person;
    }

    @Override
    public Person update(Person person) {
        sessionFactory
                .getCurrentSession()
                .update(person);

        return person;
    }

    @Override
    public void delete(Long id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete Person where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
