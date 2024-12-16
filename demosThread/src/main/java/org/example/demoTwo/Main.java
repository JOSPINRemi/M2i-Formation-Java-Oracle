package org.example.demoTwo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        demoExecutorServiceWithRunnable();

//        demoThreadPool();

        demoScheduledExecutorService();
    }

    public static void demoExecutorServiceWithRunnable() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("Task avec un runnable"));

        executor.shutdown();
//        Attends jusqu'à 5 secondes la fin des tâches
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void demoThreadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println("Task " + taskId + " executée par " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }

    public static void demoScheduledExecutorService() throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

//        Tâche différée
        scheduler.schedule(() -> System.out.println("Task executée après 3 secondes"), 3, TimeUnit.SECONDS);

//        Tâche périodique
        scheduler.scheduleAtFixedRate(() -> System.out.println("Task périodique executée"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(7000);
        scheduler.shutdown();
    }
}
