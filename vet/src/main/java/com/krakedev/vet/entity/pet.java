package com.krakedev.vet.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_pet", nullable = false, length = 100)
    private String name;
    @Column(name = "species", nullable = false, length = 100)
    private String species;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "owner_name", nullable = false, length = 100)
    private String ownerName;
    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;
    @PrePersist
    public void prePersist() {
        this.registerDate = LocalDate.now();
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pet", nullable = false)
    private StatusPet statusPet;
}