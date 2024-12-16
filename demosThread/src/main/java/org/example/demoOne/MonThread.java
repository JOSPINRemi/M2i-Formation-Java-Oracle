package org.example.demoOne;

public class MonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread " + getName() + " avec classe étendue : étape : " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread " + getName() + " interrompu");
            }
        }
    }
}
