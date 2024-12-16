package org.example.exercice2;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5 ; i++) {
            Thread thread = new Thread(new MaTacheRunnable(i));
            thread.start();
        }
    }
}
