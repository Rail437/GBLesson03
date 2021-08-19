package com.example.lesson3.controller;

import com.example.lesson3.model.Person;
import com.example.lesson3.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author antonkuznetsov
 */
@Controller
@RequestMapping("/person")
@Log4j2
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
//    @ModelAttribute("persons")
    public String findAll(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person";
    }

    @GetMapping("/filter")
    public String findByName(@RequestParam String name, @RequestParam Integer age) {
        log.info(name, age);
        return "person";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("persons", personService.findById(id));
        return "person";
    }

    @PostMapping
    public String save(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/person";
    }

    @PostMapping("/upload")
    public void upload(MultipartFile file) {

    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public String handleException(NoSuchElementException exception) {
//        return "error";
//    }
}
