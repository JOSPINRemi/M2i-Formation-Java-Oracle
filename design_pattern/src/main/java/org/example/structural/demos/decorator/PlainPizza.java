package org.example.structural.demos.decorator;

public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza de base";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
