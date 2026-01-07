package com.krakedev.vet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/vet")
public class helloController {
    @GetMapping("/welcome")
    public String hello() {
        return "Welcome to the Veterinary Management System";
    }
}