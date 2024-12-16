package org.example.demoOne;

public class MonRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " avec implémentation Runnable : étape : " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " interrompu");
            }
        }
    }
}
