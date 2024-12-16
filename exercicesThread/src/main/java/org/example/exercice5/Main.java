package org.example.exercice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer>[] futures = new Future[10];

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            futures[i -1] = executor.submit(() -> taskId * taskId);
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                System.out.println("Résultat de la tâche " + (i + 1) + " : " + futures[i].get());
            } catch (Exception e) {
                System.out.println("Erreur lors de la récupération pour " + i);
            }
        }

        executor.shutdown();
    }
}
