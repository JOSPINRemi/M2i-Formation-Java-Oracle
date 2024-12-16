package org.example.exercice2;

public class MaTacheRunnable implements Runnable {
    private int value;

    public MaTacheRunnable(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("Le carré de " + value + " est " + Math.pow(value, 2));
    }
}
