package com.krakedev.vet.controllers;

//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.vet.entity.Pet;
import com.krakedev.vet.entity.StatusPet;
import com.krakedev.vet.service.PetService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetController {
    
    private final PetService petService;

    @PostMapping("/register")
    public ResponseEntity<?> listPets(@RequestBody Pet pet) {
        Pet newPet = petService.registerPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listPets() {
        List<Pet> pets = petService.listPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity <?> findPetByName(@PathVariable String name) {
        Optional<Pet> pet = petService.findPetByName(name);
        return pet.isPresent() ? ResponseEntity.ok(pet.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Pet with name " + name + " not found");
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity <?> findPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findPetById(id);
        return pet.isPresent() ? ResponseEntity.ok(pet.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Pet with id " + id + " not found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
       try {
           Pet petUpdated = new Pet();
           petUpdated.setName(pet.getName());
           petUpdated.setSpecies(pet.getSpecies());
           petUpdated.setAge(pet.getAge());
           petUpdated.setOwnerName(pet.getOwnerName());
           
           Pet petBDD = petService.updatePet(id, petUpdated);
           return ResponseEntity.ok(petBDD);
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<?> deletePet(@PathVariable Long id) {
         try {
             petService.deletePet(id);
             return ResponseEntity.ok("Pet with id " + id + " deleted");
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
         }
     }

        @PutMapping("/status/{id}")    
        public ResponseEntity<?> changePetStatus(@PathVariable Long id, @RequestBody StatusPet statusPet) {
            try {
                Pet petUpdate = petService.changePetStatus(id, statusPet);
                return ResponseEntity.ok(petUpdate);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }

        @GetMapping("/listStatus/{statusPet}")
        public ResponseEntity<?> findPetByStatus(@PathVariable StatusPet statusPet) {
            List<Pet> pets = petService.findPetByStatus(statusPet);
            return ResponseEntity.ok(pets);
        }


}

 /*private final List<Pet> pet = new ArrayList<>();

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
    }*/   
