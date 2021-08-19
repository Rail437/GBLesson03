package com.example.lesson3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "My Friend");
        return "hello";
    }

}
