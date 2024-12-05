package org.example.exercise6;

public class PackDecorator extends ToyDecorator {
    public PackDecorator(Toy toy) {
        super(toy);
    }

    @Override
    public void pack() {
        super.pack();
    }
}
