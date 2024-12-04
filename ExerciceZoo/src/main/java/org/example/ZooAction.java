package org.example;

import java.util.List;

public interface ZooAction {
    void addAnimal(Animal animal, int idEnclosure);
    List<Animal> getAnimals();
    void fedAnimal(int animalId);
}
