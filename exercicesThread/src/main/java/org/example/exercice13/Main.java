package org.example.exercice13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Lock reentrantLock = new ReentrantLock();
    private static SharedResource sharedResource;

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        sharedResource = new SharedResource("imprimante");
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " tente d'utiliser " + sharedResource.getName());
                try {
                    if (reentrantLock.tryLock(10, TimeUnit.SECONDS))
                        System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise " + sharedResource.getName());
                    else
                        System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à " + sharedResource.getName() + "(temps d'attente dépassé");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser " + sharedResource.getName() + " et libère le verrou");
                }
            }
        }, 3);
        runThreads(threads);
        System.out.println();
    }

    private static Thread[] createThreads(Runnable task, int size) {
        Thread[] threads = new Thread[size];
        for (int i = 0; i < threads.length; i++) {
            int taskId = i + 1;
            threads[i] = new Thread(task, "Tâche-" + taskId);
        }
        return threads;
    }

    private static void runThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }
}
