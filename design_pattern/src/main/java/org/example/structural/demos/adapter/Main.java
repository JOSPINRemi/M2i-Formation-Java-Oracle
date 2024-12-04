package org.example.structural.demos.adapter;

public class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

//        Utilisation de mon adaptateur
        Target target = new Adapter(adaptee);

        target.request();
    }
}
