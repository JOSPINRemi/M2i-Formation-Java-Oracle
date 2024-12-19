package org.example.exercice21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Connexion au serveur");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                executor.execute(task);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
