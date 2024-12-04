package org.example.creational.demos.singleton;

public class SingletonExample {
    private static SingletonExample instance;

    private SingletonExample() {
        System.out.println("Singleton instancié");
    }

    public static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
}
