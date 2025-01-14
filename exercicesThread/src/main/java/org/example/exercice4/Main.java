package org.example.exercice4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 11; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println("Tâche " + taskId + " exécutée par " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}
