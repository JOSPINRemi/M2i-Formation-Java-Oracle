package org.example.exercise6;

public abstract class ToyDecorator implements Toy {
    protected Toy toy;

    public ToyDecorator(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void pack() {
        toy.pack();
    }
}
