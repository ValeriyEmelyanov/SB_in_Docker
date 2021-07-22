package com.example.simpledockerspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDockerController {

    @GetMapping("/")
    public String hello() {
        return "Hello Docker!";
    }
}
