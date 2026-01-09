package com.krakedev.vet.service;

import java.util.List;

import com.krakedev.vet.entity.Pet;

public interface PetService {

    Pet registerPet(Pet pet);
    List<Pet> listPets();
    Pet findPetById(Long id);
    Pet findPetByName(String name);
    Pet updatePet(Long id, Pet pet);
    void deletePet(Long id);
}
