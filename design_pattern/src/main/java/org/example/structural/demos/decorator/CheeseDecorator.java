package org.example.structural.demos.decorator;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", au fromage";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }
}
