package org.example.creational.exercises.exercise4.entity;

public class Dog implements  Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog make sound : Bark");
    }
}
