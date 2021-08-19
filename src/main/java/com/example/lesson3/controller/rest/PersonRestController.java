package com.example.lesson3.controller.rest;

import com.example.lesson3.model.Person;
import com.example.lesson3.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author antonkuznetsov
 */
@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public Person findAll(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping("async")
    public DeferredResult<Person> getPersons() {
        DeferredResult<Person> result = new DeferredResult<>();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                Thread.sleep(10000);
                result.setResult(new Person());
            } catch (InterruptedException e) {
                e.printStackTrace();
                result.setErrorResult("");
            }

        });
        return result;
    }
}
