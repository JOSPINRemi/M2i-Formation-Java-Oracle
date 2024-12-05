package org.example.exercise6;

public class TeddyBearFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new TeddyBear();
    }
}
