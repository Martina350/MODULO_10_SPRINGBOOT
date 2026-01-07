package com.krakedev.vet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private String ownerName;
}
