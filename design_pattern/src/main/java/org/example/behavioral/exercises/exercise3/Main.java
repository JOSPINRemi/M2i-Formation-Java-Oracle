package org.example.behavioral.exercises.exercise3;

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();

        Observer observer1 = new MyObserver("MyObserver");
        Observer observer2 = new MyOtherObserver("MyOtherObserver");

        manager.addObserver(observer1);
        manager.addObserver(observer2);

        manager.notifyObservers("Hello World");
    }
}
