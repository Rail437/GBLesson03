package com.example.lesson3.service;

import com.example.lesson3.model.Person;
import com.example.lesson3.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author antonkuznetsov
 */
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public void save(Person person) {
        personRepository.save(person);
    }
}
