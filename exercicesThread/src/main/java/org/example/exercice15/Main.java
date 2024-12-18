package org.example.exercice15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " atteint l'étape 1");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " atteint l'étape 2");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " atteint l'étape 3");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        };

        for (int i = 1; i < 4; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
