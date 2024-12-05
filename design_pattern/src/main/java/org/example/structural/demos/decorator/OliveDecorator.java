package org.example.structural.demos.decorator;

public class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", avec olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}
