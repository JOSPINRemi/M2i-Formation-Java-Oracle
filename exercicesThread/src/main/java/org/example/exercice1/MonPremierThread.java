package org.example.exercice1;

public class MonPremierThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + " - Compteur : " + i);
        }
    }
}
