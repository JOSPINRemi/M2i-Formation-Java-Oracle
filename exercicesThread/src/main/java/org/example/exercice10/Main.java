package org.example.exercice10;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static AtomicLong counter = new AtomicLong(1);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            int multiplicateur = i + 2;
            threads[i] = new Thread(() -> {
                counter.updateAndGet(v -> v * multiplicateur);
                System.out.println(Thread.currentThread().getName() + " multiplicateur : " + multiplicateur + " = " + counter.get());
            });
            threads[i].start();
        }

        for (Thread thread : threads) thread.join();

        System.out.println("Valeur finale : " + counter.get());
    }
}
