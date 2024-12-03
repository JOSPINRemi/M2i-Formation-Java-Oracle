package org.example;

import java.util.List;

public interface ZooAction {
    void addAnimal(Animal animal);
    List<Animal> getAnimals();
    void fedAnimal(int animalId);
}
