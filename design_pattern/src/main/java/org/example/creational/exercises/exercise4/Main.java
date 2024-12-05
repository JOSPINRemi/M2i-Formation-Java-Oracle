package org.example.creational.exercises.exercise4;

import org.example.creational.exercises.exercise4.entity.Animal;
import org.example.creational.exercises.exercise4.factory.AnimalFactory;
import org.example.creational.exercises.exercise4.factory.CatFactory;
import org.example.creational.exercises.exercise4.factory.DogFactory;

public class Main {
    public static void main(String[] args) {
        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();
    }
}
