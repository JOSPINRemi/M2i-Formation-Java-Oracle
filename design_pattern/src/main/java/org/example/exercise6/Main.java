package org.example.exercise6;

public class Main {
    public static void main(String[] args) {
        ToyFactory teddyBearFactory = new TeddyBearFactory();
        Toy teddyBear = teddyBearFactory.createToy();

        Elf elf = new Elf("Elfy");
        teddyBear.pack();
    }
}
