package org.example.creational.exercises.exercise4.factory;

import org.example.creational.exercises.exercise4.entity.Animal;
import org.example.creational.exercises.exercise4.entity.Dog;

public class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
