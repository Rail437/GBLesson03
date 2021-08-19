package com.example.lesson3.repository;

import com.example.lesson3.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author antonkuznetsov
 */
@Repository
public class PersonRepository {
    private Map<Long, Person> personDb;

    public PersonRepository() {
        this.personDb = new ConcurrentHashMap<>();
        personDb.put(1l, Person.builder()
                .id(1l)
                .age(20)
                .name("max")
                .temperature(37)
                .build());
    }

    public List<Person> findAll() {
        return personDb.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Person> findById(Long id) {
        return personDb.values().stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public void save(Person person) {
        if (person.getId() == null) {
            person.setId(personDb.size() + 1L);
        }
        personDb.put(person.getId(), person);
    }
}
