package com.example.lesson3.controller;


import com.example.lesson3.model.Product;
import com.example.lesson3.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "myProducts";
    }

    @GetMapping("/{name}")
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        return "myProducts";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "myProducts";
    }

    @PostMapping
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

}
