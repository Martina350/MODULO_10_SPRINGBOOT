package com.krakedev.vet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.vet.entity.Pet;
import com.krakedev.vet.entity.StatusPet;
import com.krakedev.vet.repository.PetRepository;
import com.krakedev.vet.service.PetService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    
    private final PetRepository petRepository;

    @Override
    public Pet registerPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> listPets() {
        return petRepository.findAll();
    }

    @Override
    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public Optional<Pet> findPetByName(String name) {
        return petRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Pet updatePet(Long id, Pet pet) {
        Pet petUpdated = petRepository.findById(id)
        .orElseThrow(() -> new Exception("Pet by ID: " + id + " not found"));
        petUpdated.setName(pet.getName());
        petUpdated.setSpecies(pet.getSpecies());
        petUpdated.setAge(pet.getAge());
        petUpdated.setOwnerName(pet.getOwnerName());
        return petRepository.save(petUpdated);
    }

    @Override
    @SneakyThrows
    public void deletePet(Long id) {
        petRepository.findById(id)
        .orElseThrow(() -> new Exception("Pet by ID: " + id + " not found"));
        petRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public Pet changePetStatus(Long id, StatusPet statusPet) {
        Pet pet = petRepository.findById(id)
        .orElseThrow(() -> new Exception("Pet by ID: " + id + " not found"));
        pet.setStatusPet(statusPet);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findPetByStatus(StatusPet statusPet) {
        return petRepository.findByStatusPet(statusPet);
    }
}
