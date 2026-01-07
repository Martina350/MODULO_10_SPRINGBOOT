package com.krakedev.vet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.vet.entity.pet;

@RestController
@RequestMapping("/api/pet")
public class petController {
    private List<pet> pet = new ArrayList<>();

    private petController() {
        pet.add(new pet(1, "Brownie", "Dog", 5, "Martina"));
        pet.add(new pet(2, "Lola", "Cat", 5, "Daniela"));
        pet.add(new pet(3, "Panfleta", "Rabbit", 1, "Abigail"));
    }

    @GetMapping
    public List<pet> listPets() {
        return pet;
    }
}
