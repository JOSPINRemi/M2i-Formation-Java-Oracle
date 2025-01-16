package org.example.exercisespringbatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
public class Dinosaur {
    @Id
    private long id;
    private String name;
    private String species;
    private double ageMillionYears;

    public Dinosaur() {
    }

    public Dinosaur(long id, String name, String species, double ageMillionYears) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.ageMillionYears = ageMillionYears;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getAgeMillionYears() {
        return ageMillionYears;
    }

    public void setAgeMillionYears(double ageMillionYears) {
        this.ageMillionYears = ageMillionYears;
    }
}
