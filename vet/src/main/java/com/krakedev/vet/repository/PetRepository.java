package com.krakedev.vet.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.vet.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findById(Long id);
    Optional<Pet> findByName(String name);
    Optional<Pet> findByOwnerName(String ownerName);
    Optional<Pet> findByRegisterDate(LocalDate registerDate);
}
