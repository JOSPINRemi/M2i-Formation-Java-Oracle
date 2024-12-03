package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Enclosure {
    private int id;
    private String name;
    private List<Animal> animals;

    public Enclosure(int id, String name, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(int id) {
        animals = animals.stream().filter(animal -> animal.getId() == id).collect(Collectors.toList());
    }
}
