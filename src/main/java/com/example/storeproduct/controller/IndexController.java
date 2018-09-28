package com.example.storeproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/api/products")
    public String index() {
        return "Hello world";
    }

}
