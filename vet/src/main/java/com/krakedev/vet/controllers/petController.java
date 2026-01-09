package com.krakedev.vet.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.vet.entity.Pet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/pet")
public class PetController {
    private List<Pet> pet = new ArrayList<>();

    private PetController() {
    Pet p1 = new Pet();
    p1.setId(1L);
    p1.setName("Brownie");
    p1.setSpecies("Dog");
    p1.setAge(5);
    p1.setOwnerName("Martina");

    Pet p2 = new Pet();
    p2.setId(2L);
    p2.setName("Lola");
    p2.setSpecies("Cat");
    p2.setAge(5);
    p2.setOwnerName("Daniela");

    Pet p3 = new Pet();
    p3.setId(3L);
    p3.setName("Panfleta");
    p3.setSpecies("Rabbit");
    p3.setAge(1);
    p3.setOwnerName("Abigail");

    pet.add(p1);
    pet.add(p2);
    pet.add(p3);
    }

    @GetMapping
    public List<Pet> listPets() {
        return pet;
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable int id) {
        java.util.Optional<Pet> pet = this.pet.stream().filter(p -> p.getId() == id).findFirst();
        return pet.orElse(null);    
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet newPet) {
        pet.add(newPet);
        return newPet;
    }
    
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable int id) {
        pet.removeIf(p -> p.getId() == id);
    }
}
