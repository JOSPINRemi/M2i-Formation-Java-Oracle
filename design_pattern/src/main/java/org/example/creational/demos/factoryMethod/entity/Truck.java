package org.example.creational.demos.factoryMethod.entity;

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Conduire un camion");
    }
}
