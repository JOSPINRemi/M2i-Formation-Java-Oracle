package org.example.IHM;

import org.example.Animal;
import org.example.Enclosure;
import org.example.ZooAction;

import java.util.ArrayList;
import java.util.List;

public class ZooManager implements ZooAction {
    private List<Enclosure> enclosures;

    public ZooManager() {
        this.enclosures = new ArrayList<>();
    }

    public List<Enclosure> getEnclosures() {
        return enclosures;
    }

    @Override
    public void addAnimal(Animal animal, int idEnclosure) {

    }

    @Override
    public List<Animal> getAnimals() {
        return List.of();
    }

    @Override
    public void fedAnimal(int animalId) {

    }
}
