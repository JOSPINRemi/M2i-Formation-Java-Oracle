package org.example.creational.demos.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonExample singletonExample1 = org.example.creational.demos.singleton.SingletonExample.getInstance();
        org.example.creational.demos.singleton.SingletonExample singletonExample2 = org.example.creational.demos.singleton.SingletonExample.getInstance();

        System.out.println("Comparaison des deux instances de singleton : " + (singletonExample1 == singletonExample2));
    }
}
