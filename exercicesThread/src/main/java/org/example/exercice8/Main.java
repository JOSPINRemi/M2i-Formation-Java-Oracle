package org.example.exercice8;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] atomicThreads = createAtomicThreads();
        for (Thread atomicThread : atomicThreads) atomicThread.start();
        for (Thread atomicThread : atomicThreads) {
            try {
                atomicThread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread " + atomicThread.getName() + " interrompu");
            }
        }
        System.out.println("Valeur finale du compteur : " + counter.get());
    }

    private static Thread[] createAtomicThreads() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1_000; j++) {
                    counter.incrementAndGet();
                }
            });
        }
        return threads;
    }
}
