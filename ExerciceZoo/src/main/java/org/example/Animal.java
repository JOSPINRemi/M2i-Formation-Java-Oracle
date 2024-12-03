package org.example;

public abstract class Animal {
    private int id;
    private String name;
    private String species;

    public Animal(int id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public abstract String getDetails();
    public abstract void eat();
}
