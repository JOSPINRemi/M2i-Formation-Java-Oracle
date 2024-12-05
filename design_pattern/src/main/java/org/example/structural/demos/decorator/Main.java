package org.example.structural.demos.decorator;

public class Main {
    public static void main(String[] args) {
        Pizza basePizza = new PlainPizza();
        System.out.println(basePizza.getDescription() + " " + basePizza.getCost());

        Pizza cheesePizza = new CheeseDecorator(basePizza);
        System.out.println(cheesePizza.getDescription() + " " + cheesePizza.getCost());

        Pizza olivePizza = new OliveDecorator(cheesePizza);
        System.out.println(olivePizza.getDescription() + " " + olivePizza.getCost());
    }
}
