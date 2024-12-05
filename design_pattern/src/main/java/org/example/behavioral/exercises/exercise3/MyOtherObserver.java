package org.example.behavioral.exercises.exercise3;

public class MyOtherObserver implements Observer {
    private String name;

    public MyOtherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " l'événement " + message + " est en cours");
    }
}
