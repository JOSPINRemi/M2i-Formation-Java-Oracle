package org.example.exercise6;

public class Elf implements Observer {

    private String name;

    public Elf(String name) {
        this.name = name;
    }

    @Override
    public void onNotify(String event) {
        System.out.println(name + ": " + event);
    }
}
