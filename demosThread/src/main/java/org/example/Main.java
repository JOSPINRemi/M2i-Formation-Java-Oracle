package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        demoCreationThreads();

//        Creation de plusieurs threads
        /*for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SimpleTask("Thread-" + i));
            thread.start();
        }
        System.out.println("Tous les threads sont démarrés");*/

        demoInterruptionThreads();
    }

    public static void demoCreationThreads() throws ExecutionException, InterruptedException {
//        Avec la classe Thread
        MonThread thread1 = new MonThread();
        thread1.start();

//        Avec l'interface Runnable
        Thread thread2 = new Thread(new MonRunnable());
        thread2.start();

//        Runnable avec une lambda
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Thread lambda : étape " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("Thread lambda interrompu");
                }
            }
        });
        thread3.start();

//        Callable avec ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Callable : étape " + i);
                Thread.sleep(400);
            }
            return "Resultat du callable terminé";
        };
        Future<String> futureResult = executor.submit(callableTask);
        System.out.println("Résultat de callable : " + futureResult.get());
        executor.shutdown();
    }

    public static void demoInterruptionThreads() throws InterruptedException {
        Thread threadInterruption = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Thread Interrompu : étape " + i);
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrompu pendant le sommeil");
                    break;
                }
            }
        });
        threadInterruption.start();
//        Attendre avant d'interrompre
        Thread.sleep(2000);
        threadInterruption.interrupt();
        System.out.println("Fin démo interruption");
    }
}