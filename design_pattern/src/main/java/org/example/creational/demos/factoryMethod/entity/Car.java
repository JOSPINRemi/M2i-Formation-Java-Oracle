package org.example.creational.demos.factoryMethod.entity;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Conduire une voiture");
    }
}
