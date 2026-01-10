package com.krakedev.vet.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.vet.entity.Pet;
import com.krakedev.vet.entity.StatusPet;

public interface PetService {

    Pet registerPet(Pet pet);
    List<Pet> listPets();
    Optional<Pet> findPetById(Long id);
    Optional<Pet> findPetByName(String name);
    Pet updatePet(Long id, Pet pet);
    void deletePet(Long id);
    Pet changePetStatus(Long id, StatusPet statusPet);
    List<Pet> findPetByStatus(StatusPet statusPet);
}
