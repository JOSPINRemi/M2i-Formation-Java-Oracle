package org.example.exercise6;

import java.util.ArrayList;
import java.util.List;

public class TeddyBear implements Toy {
    private List<Observer> observers;

    public TeddyBear() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void pack() {
        System.out.println("Teddy bear is packed");
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.onNotify(event);
        }
    }
}
