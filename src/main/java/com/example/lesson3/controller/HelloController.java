package com.example.lesson3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author antonkuznetsov
 */
@Controller
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("name", "Anton");
        return "hello";
    }
}
