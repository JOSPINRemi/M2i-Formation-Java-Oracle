package org.example.exercice14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " commence à charger les données.");
                System.out.println(Thread.currentThread().getName() + " a terminé le chargement de données.");
                barrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 1; i < 4; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
