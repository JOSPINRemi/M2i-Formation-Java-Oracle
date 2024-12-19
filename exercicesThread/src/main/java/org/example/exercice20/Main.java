package org.example.exercice20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long threadExecutionTime = System.currentTimeMillis();
        long virtualThreadExecutionTime = System.currentTimeMillis();

        Runnable task = () -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        try(var executor = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 10; i++) {
                executor.execute(task);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        threadExecutionTime = System.currentTimeMillis() - threadExecutionTime;

        try(var virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                virtualExecutor.execute(task);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        virtualThreadExecutionTime = System.currentTimeMillis() - virtualThreadExecutionTime;

        System.out.println("Le temps d'execution d'un thread natif est de " + threadExecutionTime + " ms");
        System.out.println("Le temps d'execution d'un virtual thread est de " + virtualThreadExecutionTime + " ms");
    }
}
