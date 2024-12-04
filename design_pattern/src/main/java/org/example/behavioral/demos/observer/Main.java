package org.example.behavioral.demos.observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new MyObserver("Observer 1");
        Observer observer2 = new MyObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("Un joli message 1");
        subject.notifyObservers("Un joli message 2");

        subject.removeObserver(observer2);

        subject.notifyObservers("Un joli message 3");
    }
}
