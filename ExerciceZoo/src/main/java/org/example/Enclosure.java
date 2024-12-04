package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Enclosure {
    private int id;
    private String name;
    private List<Animal> animals;

    public Enclosure(int id, String name) {
        this.id = id;
        this.name = name;
        this.animals = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Enclosure{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
